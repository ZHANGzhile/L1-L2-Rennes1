package fr.istic.cal.interpreter

/*
 * VEUILLEZ INSCRIRE CI-DESSOUS VOTRE NOM ET VOTRE PRENOM :
 *
 * ETUDIANT 1 :
 *
 * ETUDIANT 2 :
 *
 */

/**
 * définition d'une exception pour le cas des listes vides
 */
case object ExceptionListeVide extends Exception

/**
 * définition d'une exception pour le cas des listes de tailles différentes
 */
case object ExceptionListesDeLongueursDifferentes extends Exception

object Interpreter {

  /**
   * UN INTERPRETER POUR LE LANGAGE WHILE
   *
   */

  /**
   *  GESTION DE LA MEMOIRE DE L'INTERPRETEUR
   */

  /**
   *  définition d'un type Memory pour représenter une mémoire
   */
  type Memory = List[(Variable, Value)]

  /**
   * @param v : une variable
   * @param mem : une mémoire
   * @return m(v), c'est-à-dire la valeur de la variable v dans la mémoire mem,
   * la valeur par défaut si la variable v n'est pas présente dans la mémoire mem
   */
  // TODO TP2
  def lookUp(v: Variable, mem: Memory): Value = {
    mem match {
      case Nil => NlValue
      case (e1, e2) :: l => if (e1 == v) e2
      else lookUp(v, l)
    }
  }

  /**
   * @param v : une variable
   * @param d : une valeur
   * @param mem : une mémoire
   * @return la mémoire modifiée par l'affectation [v->d]
   */
  // TODO TP2
  def assign(v: Variable, d: Value, mem: Memory): Memory = {
    mem match {
      case Nil => mem ::: List((v, d))
      case (e1, e2) :: l => if (e1 == v) (v, d) :: l
      else (e1, e2) :: assign(v, d, l)
    }
  }

  /**
   *  TRAITEMENT DES EXPRESSIONS DU LANGAGE WHILE
   */

  /**
   * @param expression : un AST décrivant une expression du langage WHILE
   * @return la valeur de l'expression
   */
  // TODO TP2
  def interpreterExpr(expression: Expression, mem: Memory): Value = {
    expression match {
      case Nl                   => NlValue
      case Cst(e)               => CstValue(e)
      case VarExp(e)            => lookUp(Var(e), mem)
      case Cons(e1, e2)         => ConsValue(interpreterExpr(e1, mem), interpreterExpr(e2, mem))
      case Hd(e) => interpreterExpr(e, mem) match {
        case ConsValue(e1, e2)  => e1
        case _                  => NlValue
      }
      case Tl(e) => interpreterExpr(e, mem) match {
        case ConsValue(e1, e2)  => e2
        case _                  => NlValue
      }
      case Eq(e1, e2)           => if (interpreterExpr(e1, mem) == interpreterExpr(e2, mem)) CstValue("")
      else NlValue
    }
  }

  /**
   * la fonction interpreterExpr ci-dessus calcule la valeur associée à une expression
   * il peut être utile de produire à l'inverse une expression associée à une valeur
   * la fonction valueToExpression ci-dessous construira l'expression la plus simple associée à une valeur
   *
   * @param value : une valeur du langage WHILE
   * @return l'AST décrivant l'expression de cette valeur
   */
  // TODO TP2
  def valueToExpression(value: Value): Expression = {
    value match {
      case NlValue           => Nl
      case CstValue(e)       => Cst(e)
      case ConsValue(e1, e2) => Cons(valueToExpression(e1), valueToExpression(e2))
    }
  }

  /**
   *
   *  TRAITEMENT DES COMMANDES DU LANGAGE WHILE
   */

  /**
   * @param command : un AST décrivant une commande du langage WHILE
   * @param memory : une mémoire
   * @return la mémoire après l'interprétation de command
   */
  // TODO TP2
  def interpreterCommand(command: Command, memory: Memory): Memory = {
    command match {
      case Nop                     => memory
      case Set(v, e)               => assign(v, interpreterExpr(e, memory), memory)
      case While(e, c)             =>
        interpreterExpr(e, memory) match {
          case NlValue => memory
          case _       => interpreterCommand(command, interpreterCommands(c, memory))
        }
      case For(e, c)               =>
        interpreterExpr(e, memory) match {
          case NlValue => memory
          case _       => interpreterCommand(For(valueToExpression(interpreterExpr(Tl(e), memory)), c), interpreterCommands(c, memory))
        }
      case If(e, thenC, elseC)     =>
        interpreterExpr(e, memory) match {
          case NlValue => interpreterCommands(elseC, memory)
          case _       => interpreterCommands(thenC, memory)
        }
    }
  }

  /**
   * @param commands : une liste non vide d'AST décrivant une liste non vide de commandes du langage WHILE
   * @param memory : une mémoire
   * @return la mémoire après l'interprétation de la liste de commandes
   */
  // TODO TP2
  def interpreterCommands(commands: List[Command], memory: Memory): Memory = {
    def a(command: Command, commands: List[Command], memory: Memory): Memory = { interpreterCommands(commands, interpreterCommand(command, memory)) }

    commands match {
      //case Nil       => List()
      case e :: Nil  => interpreterCommand(e, memory)
      case Nop :: e2 => interpreterCommands(e2, memory)
      case e1 :: e2  => a(e1, e2, memory)
    }
  }

  /**
   *
   *  TRAITEMENT DES PROGRAMMES DU LANGAGE WHILE
   */

  /**
   * @param vars : une liste non vide décrivant les variables d'entrée d'un programme du langage WHILE
   * @param vals : une liste non vide de valeurs
   * @return une mémoire associant chaque valeur à la variable d'entrée correspondant
   */
  // TODO TP2
  def interpreterMemorySet(vars: List[Variable], vals: List[Value]): Memory = {
    (vars, vals) match {
      case ((e :: Nil), (e1 :: Nil)) => assign(e, e1, List())
      case ((e1 :: m1), (e2 :: m2))  => interpreterMemorySet(m1, m2) ++ assign(e1, e2, List())
    }
  }

  /**
   * @param vars : une liste non vide décrivant les variables de sortie d'un programme du langage WHILE
   * @param memory : une mémoire
   * @return la liste des valeurs des variables de sortie
   */
  // TODO TP2
  def interpreterMemoryGet(vars: List[Variable], memory: Memory): List[Value] = {
    vars match {
      case e :: Nil => List(lookUp(e, memory))
      case e :: m   => List(lookUp(e, memory)) ++ interpreterMemoryGet(m, memory)
    }
  }

  /**
   * @param program : un AST décrivant un programme du langage WHILE
   * @param vals : une liste de valeurs
   * @return la liste des valeurs des variables de sortie
   */
  // TODO TP2
  def interpreter(program: Program, vals: List[Value]): List[Value] = {
    program match {
      case Progr(in, body, out) => interpreterMemoryGet(out, interpreterCommands(body, interpreterMemorySet(in, vals)))
    }
  }

  /**
   * UTILISATION D'UN ANALYSEUR SYNTAXIQUE POUR LE LANGAGE WHILE
   *
   * les 3 fonctions suivantes permettent de construire un arbre de syntaxe abstraite
   * respectivement pour une expression, une commande, un programme
   */

  /**
   * @param s : une chaine de caractères représentant la syntaxe concrète d'une expression du langage WHILE
   * @return un arbre de syntaxe abstraite pour cette expression
   */
  def readWhileExpression(s: String): Expression = { WhileParser.analyserexpression(s) }

  /**
   * @param s : une chaine de caractères représentant la syntaxe concrète d'une commande du langage WHILE
   * @return un arbre de syntaxe abstraite pour cette commande
   */
  def readWhileCommand(s: String): Command = { WhileParser.analysercommand(s) }

  /**
   * @param s : une chaine de caractères représentant la syntaxe concrète d'un programme du langage WHILE
   * @return un arbre de syntaxe abstraite pour ce programme
   */
  def readWhileProgram(s: String): Program = { WhileParser.analyserprogram(s) }

}
