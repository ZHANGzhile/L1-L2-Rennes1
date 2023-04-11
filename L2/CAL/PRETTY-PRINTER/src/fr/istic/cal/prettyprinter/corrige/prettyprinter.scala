package fr.istic.cal.prettyprinter.corrige

import scala.util.Try

/**
 * définition d'une exception pour le cas des listes vides de commandes
 */
case object ExceptionListeVide extends Exception

object Prettyprinter {

  /**
   * UN PRETTY-PRINTER POUR LE LANGAGE WHILE
   *
   */

  /**
   * définition d'un type pour les spécifications d'indentation
   */
  type IndentSpec = List[(String, Int)]

  /**
   * définition d'une valeur d'indentation par défaut
   */
  val indentDefault: Int = 1

  /**
   *  TRAITEMENT DES EXPRESSIONS DU LANGAGE WHILE
   */

  /**
   * @param expression : un AST décrivant une expression du langage WHILE
   * @return une chaîne représentant la syntaxe concrète de l'expression
   */
  def prettyPrintExpr(expression: Expression): String = {
    expression match {
      case Nl               => "nil"
      case Cst(s)           => s
      case VarExp(s)        => s
      case Cons(arg1, arg2) => "(cons " + prettyPrintExpr(arg1) + " " + prettyPrintExpr(arg2) + ")"
      case Hd(arg)          => "(hd " + prettyPrintExpr(arg) + ")"
      case Tl(arg)          => "(tl " + prettyPrintExpr(arg) + ")"
      case Eq(arg1, arg2)   => prettyPrintExpr(arg1) + " =? " + prettyPrintExpr(arg2)
    }
  }

  /**
   *  FONCTIONS AUXILIAIRES DE TRAITEMENT DE CHAINES POUR L'INDENTATION DES COMMANDES
   *  OU LA PRESENTATION DU PROGRAMME
   */

  /**
   * recherche d'une valeur d'indentation dans une liste de spécifications d'indentation
   *
   * @param context une chaîne de caractères décrivant un contexte d'indentation
   * @param is une liste de spécifications d'indentation, chaque spécification étant un couple (un contexte,une indentation)
   * les contextes possibles seront, en majuscules, "WHILE", "FOR", "IF", ou "PROGR".
   * @return l'indentation correspondant à context
   */
  def indentSearch(context: String, is: IndentSpec): Int = {
    is match{
      case Nil => indentDefault
      case e1::e2 => if(e1._1 == context) e1._2 else indentSearch(context,e2)
    }
  }
  

  /**
   * création d'une indentation
   *
   * @param n un nombre d'espaces
   * @return une chaîne de n espaces
   */
  def makeIndent(n: Int): String = {
    n match {
      case 0 => ""
      case _ => makeIndent(n - 1) + " "
    }
  }

  /**
   * ajout d'une chaîne devant chaque élément d'une liste non vide de chaînes
   *
   * @param pref une chaîne
   * @param strings une liste non vide de chaînes
   * @return une liste de chaînes obtenue par la concaténation de pref devant chaque élément de strings
   */
  def appendStringBeforeAll(pref: String, strings: List[String]): List[String] = {
    strings match {
      case e :: m => (pref + e) :: appendStringBeforeAll(pref, m)
      case Nil    => Nil
    }
  }

  /**
   * ajout d'une chaîne après chaque élément d'une liste non vide de chaînes
   *
   * @param suff une chaîne
   * @param strings une liste non vide de chaînes
   * @return une liste de chaînes obtenue par la concaténation de suff après chaque élément de strings
   */
  def appendStringAfterAll(suff: String, strings: List[String]): List[String] = {
    strings match {
      case e :: m => (e + suff) :: appendStringAfterAll(suff, m)
      case Nil    => Nil
    }
  }

  /**
   * ajout d'une chaîne après chaque élément d'une liste non vide de chaînes sauf le dernier
   *
   * @param suff une chaîne
   * @param strings une liste non vide de chaînes
   * @return une liste de chaînes obtenue par la concaténation de suff après chaque élément de strings sauf le dernier
   */
  def appendStringAfterAllButLast(suff: String, strings: List[String]): List[String] = {
    strings match {
      //case e1 :: e2 :: m => (e1 + suff) :: appendStringAfterAllButLast(suff, e2 :: m)
      case e1 :: Nil => e1 :: Nil
      case e1 :: m   => (e1 + suff) :: appendStringAfterAllButLast(suff, m)
      case Nil       => Nil
    }
  }

  /**
   * ajout d'une chaîne après le dernier élément d'une liste non vide de chaînes
   *
   * @param suff une chaîne
   * @param strings une liste non vide de chaînes
   * @return une liste de chaînes obtenue par la concaténation de suff après le dernier élément de strings
   */
  def appendStringAfterLast(suff: String, strings: List[String]): List[String] = {
    strings match {
      case e1 :: Nil => (e1 + suff) :: Nil
      case e1 :: m   => e1 :: appendStringAfterLast(suff, m)
      case Nil       => Nil
    }
  }

  /**
   *
   *  TRAITEMENT DES COMMANDES DU LANGAGE WHILE
   */

  /**
   * @param command : un AST décrivant une commande du langage WHILE
   * @param is : une liste de spécifications d'indentation
   * @return une liste de chaînes représentant la syntaxe concrète de la commande
   */
  def prettyPrintCommand(command: Command, is: IndentSpec): List[String] = {
    command match {
      case Nop                            => List("nop")
      case Set(Var(v), expr)              => List(v + " := " + prettyPrintExpr(expr))
      case While(cond, body)              => List("while " + prettyPrintExpr(cond) + " do") ++ appendStringBeforeAll(makeIndent(indentSearch("WHILE", is)), prettyPrintCommands(body, is)) ++ List("od")
      case For(count, body)               => List("for " + prettyPrintExpr(count) + " do") ++ appendStringBeforeAll(makeIndent(indentSearch("FOR", is)), prettyPrintCommands(body, is)) ++ List("od")
      case If(cond, body_then, body_else) => List("if " + prettyPrintExpr(cond) + " then") ++ appendStringBeforeAll(makeIndent(indentSearch("IF", is)), prettyPrintCommands(body_then, is)) ++ List("else") ++ appendStringBeforeAll(makeIndent(indentSearch("IF", is)), prettyPrintCommands(body_else, is)) ++ List("fi")
    }
  }

  /**
   * @param command : une liste non vide d'AST décrivant une liste non vide de commandes du langage WHILE
   * @param is : une liste de spécifications d'indentation
   * @return une liste de chaînes représentant la syntaxe concrète de la liste de commandes
   */
  def prettyPrintCommands(commands: List[Command], is: IndentSpec): List[String] = {
    commands match {
      case e1 :: Nil                             => prettyPrintCommand(e1, is)
      case While(cond, body) :: e2               => appendStringAfterLast(" ;", prettyPrintCommand(While(cond, body), is)) ++ prettyPrintCommands(e2, is)
      case For(count, body) :: e2                => appendStringAfterLast(" ;", prettyPrintCommand(For(count, body), is)) ++ prettyPrintCommands(e2, is)
      case If(cond, then_body, else_body) :: e2  => appendStringAfterLast(" ;", prettyPrintCommand(If(cond, then_body, else_body), is)) ++ prettyPrintCommands(e2, is)
      case e1 :: e2                              => appendStringAfterAll(" ;", prettyPrintCommand(e1, is)) ++ prettyPrintCommands(e2, is)
      case Nil                                   => Nil
    }
  }

  /**
   *
   *  TRAITEMENT DES PROGRAMMES DU LANGAGE WHILE
   */

  /**
   * @param vars : une liste non vide décrivant les paramètres d'entrée d'un programme du langage WHILE
   * @return une liste de chaînes représentant la syntaxe concrète des paramètres d'entrée du programme
   */
  def prettyPrintIn(vars: List[Variable]): String = {
    vars match {
      case Var(s) :: Nil => s
      case Var(s) :: e2  => s + ", " + prettyPrintIn(e2)
      case Nil           => ""
    }
  }

  /**
   * @param vars : une liste non vide décrivant les paramètres de sortie d'un programme du langage WHILE
   * @return une liste de chaînes représentant la syntaxe concrète des paramètres de sortie du programme
   */
  def prettyPrintOut(vars: List[Variable]): String = {
    vars match {
      case Var(s) :: Nil => s
      case Var(s) :: e2  => s + ", " + prettyPrintOut(e2)
      case Nil           => ""
    }
  }

  /**
   * @param program : un AST décrivant un programme du langage WHILE
   * @param is : une liste de spécifications d'indentation
   * @return une liste de chaînes représentant la syntaxe concrète du programme
   */
  def prettyPrintProgram(program: Program, is: IndentSpec): List[String] = {
    program match {
      case Progr(in, body, out) => List("read " + prettyPrintIn(in)) ++ List("%") ++ appendStringBeforeAll(makeIndent(indentSearch("PROGR", is)), prettyPrintCommands(body, is)) ++ List("%") ++ List("write " + prettyPrintOut(out))
    }
  }

  /**
   * @param program : un AST décrivant un programme du langage WHILE
   * @param is : une liste de spécifications d'indentation
   * @return une chaîne représentant la syntaxe concrète du programme
   */
  def prettyPrint(program: Program, is: IndentSpec): String = {
    appendStringAfterAllButLast("\n", prettyPrintProgram(program, is)).mkString
  }

  val program: Program =
    Progr(
      List(Var("X")),
      List(
        Set(Var("Y"), Nl),
        While(
          VarExp("X"),
          List(
            Set(Var("Y"), Cons(Hd(VarExp("X")), VarExp("Y"))),
            Set(Var("X"), Tl(VarExp("X")))))),
      List(Var("Y")));
  val is: IndentSpec = List(("PROGR", 2), ("WHILE", 5));

  def main(args: Array[String]): Unit = {
    println(prettyPrint(program, is));
  }

  /**
   * UTILISATION D'UN ANALYSEUR SYNTAXIQUE POUR LE LANGAGE WHILE
   *
   * les 3 fonctions suivantes permettent de construire un arbre de syntaxe abstraite
   * respectivement pour une expression, une commande, un programme
   */

  /**
   * @param s : une chaine de caractère représentant la syntaxe concrète d'une expression du langage WHILE
   * @return un arbre de syntaxe abstraite pour cette expression
   */
  def readWhileExpression(s: String): Expression = WhileParser.analyserexpression(s)

  /**
   * @param s : une chaine de caractère représentant la syntaxe concrète d'une commande du langage WHILE
   * @return un arbre de syntaxe abstraite pour cette commande
   */
  def readWhileCommand(s: String): Command = WhileParser.analysercommand(s)

  /**
   * @param s : une chaine de caractère représentant la syntaxe concrète d'un programme du langage WHILE
   * @return un arbre de syntaxe abstraite pour ce programme
   */
  def readWhileProgram(s: String): Program = WhileParser.analyserprogram(s)

}