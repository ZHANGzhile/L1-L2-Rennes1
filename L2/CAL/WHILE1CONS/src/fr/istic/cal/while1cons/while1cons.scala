package fr.istic.cal.while1cons

/*
 * VEUILLEZ INSCRIRE CI-DESSOUS VOTRE NOM ET VOTRE PRENOM :
 *
 * ETUDIANT 1 :ZHANG Zhile
 *
 * ETUDIANT 2 : MOULHERAT Hadrien
 *
 */

import scala.util.Try

/**
 * définition d'une exception pour le cas des listes vides
 */
case object ExceptionListeVide extends Exception

/**
 * définition d'une exception pour le cas des listes de tailles différentes
 */
case object ExceptionListesDeLongueursDifferentes extends Exception

object While1cons {

  /**
   * UN ELIMINATEUR D'EXPRESSIONS COMPLEXES POUR LE LANGAGE WHILE
   *
   */

  /**
   *  TRAITEMENT DES EXPRESSIONS DU LANGAGE WHILE
   */

  /**
   * @param expression : un AST décrivant une expression du langage WHILE
   * @return une paire constituée d'une liste d'affectations ayant le même effet
   * que l'expression et de la variable qui contient le résultat
   */
  // TODO TP4
  def while1ConsExprV(expression: Expression): (List[Command], Variable) = {
    
    /**
     * cette fonction juste pour obtenir la valeur de la variable
     * ex: par cette fonction, Var("A1")--> A1 
     */
    def trouveStr(x: Variable): String={
      x match{case Var(i) => i}
    }
    
    expression match{
      case Nl          =>val x =NewVar.make(); (List(Set(x, Nl)),x)
      case Cst(s)      =>val x =NewVar.make();(List(Set(x, Cst(s))),x)
      case VarExp(s)   =>(Nil,Var(s))

      case Cons(e1,e2) =>{val l1 = while1ConsExprV(e1);val l2=while1ConsExprV(e2);
                          (l1._1,l2._1) match{
                            case (Nil,Nil) =>val x =NewVar.make();(List(Set(x,Cons(e1,e2))),x)
                            case (Nil,l)   =>val x =NewVar.make();val y =NewVar.make();(List(Set(x,e2),Set(y,Cons(e1,VarExp(trouveStr(x))))),y)
                            case (l,Nil)   =>val x =NewVar.make();val y =NewVar.make();(List(Set(x,e1),Set(y,Cons(VarExp(trouveStr(x)),e2))),y)
                            case  _        =>val x =NewVar.make();(l1._1++l2._1 ++List(Set(x,Cons(VarExp(trouveStr(l1._2)),VarExp(trouveStr(l2._2))))),x)
                          }
      }

      case Hd(e)       => e match{
                          case VarExp(s) => val x =NewVar.make();(List(Set(x,Hd(e))),x)
                          case _         => val l =while1ConsExprV(e);val x =NewVar.make();(l._1 ++ List(Set(x,Hd(VarExp(trouveStr(l._2))))),x)
                          }

      case Tl(e)       => e match{
                          case VarExp(s) => val x =NewVar.make();(List(Set(x,Tl(e))),x)
                          case _         => val l =while1ConsExprV(e);val x =NewVar.make();(l._1 ++ List(Set(x,Tl(VarExp(trouveStr(l._2))))),x)
                          }

      case Eq(e1,e2)   =>{val l1 = while1ConsExprV(e1);val l2=while1ConsExprV(e2);
                          (l1._1,l2._1)match{
                            case (Nil,Nil) =>val x =NewVar.make();val y =NewVar.make();(List(Set(x,Eq(e1,e2))),x)
                            case (Nil,l)   =>val x =NewVar.make();val y =NewVar.make();(List(Set(x,e2),Set(y,Eq(e1,VarExp(trouveStr(x))))),y)
                            case (l,Nil)   =>val x =NewVar.make();val y =NewVar.make();(List(Set(x,e1),Set(y,Eq(VarExp(trouveStr(x)),e2))),y)
                            case _         =>val x =NewVar.make();(l1._1++l2._1 ++List(Set(x,Eq(VarExp(trouveStr(l1._2)),VarExp(trouveStr(l2._2))))),x)
                          }
      }

    }
  }

  /**
   * @param expression : un AST décrivant une expression du langage WHILE
   * @return une paire constituée d'une liste d'affectations et une expression simple
   * qui, combinées, ont le même effet que l'expression initiale
   */
  // TODO TP4
  def while1ConsExprSE(expression: Expression): (List[Command], Expression) = {
    
     /**
     * cette fonction juste pour obtenir la valeur de la variable
     * ex: par cette fonction, Var("A1")--> A1 
     */
    def trouveStr(x: Variable): String={
      x match{case Var(i) => i}
    }
     
    expression match{
      case Nl          => (Nil, Nl)
      case Cst(s)      => (Nil,Cst(s))
      case VarExp(s)   => (Nil,VarExp(s))

      case Cons(e1,e2) => {val a =while1ConsExprV(e1)
                           val b =while1ConsExprV(e2)
                           (a._1,b._1)match{
                              case (Nil,Nil) => (a._1++b._1,Cons(e1,e2))
                              case (Nil,l)   => (b._1++a._1,Cons(e1,VarExp(trouveStr(b._2))))
                              case (l,Nil)   => (a._1++b._1,Cons(VarExp(trouveStr(a._2)),e2))
                              case  _        => (a._1++b._1,Cons(VarExp(trouveStr(a._2)),VarExp(trouveStr(b._2))))
                           }
      }

      case Hd(e)       => e match{
                            case VarExp(s) => (Nil,Hd(e))
                            case _         => val a = while1ConsExprV(e);(a._1,Hd(VarExp(trouveStr(a._2))))
                          }

      case Tl(e)       => e match{
                            case VarExp(s)  => (Nil,Tl(e))
                            case _          => val a = while1ConsExprV(e);(a._1,Tl(VarExp(trouveStr(a._2))))
                          }

      case Eq(e1,e2)   =>{val a =while1ConsExprV(e1)
                          val b =while1ConsExprV(e2)
                           (a._1,b._1)match{
                              case (Nil,Nil) => (a._1++b._1,Eq(e1,e2))
                              case (Nil,l)   => (b._1++a._1,Eq(e1,VarExp(trouveStr(b._2))))
                              case (l,Nil)   => (a._1++b._1,Eq(VarExp(trouveStr(a._2)),e2))
                              case _         => (a._1++b._1,Eq(VarExp(trouveStr(a._2)),VarExp(trouveStr(b._2))))
                           }
      }

    }
  }

  /**
   *
   *  TRAITEMENT DES COMMANDES DU LANGAGE WHILE
   */
  /**
   * @param command : un AST décrivant une commande du langage WHILE
   * @return une liste de commandes ayant un seul constructeur par expression
   * et ayant le même effet que la commande initiale
   */
  // TODO TP4
  def while1ConsCommand(command: Command): List[Command] = {
    
     /**
     * cette fonction juste pour obtenir l'expression par cettevariable
     * ex: par cette fonction, Var("A1")--> VarExp("A1") 
     * et si la valeur de Variable est Nl, directement renvoi Nl
     */
     def trouveStr(x: Variable): Expression={
      x match{case Var(i) => if(i == "Nl") Nl
                             else VarExp(i)
      }
    }
     /**
      * @param e une Expression
      * @return une liste Command et une Expression qui correspond a le resultat d'apres apele la fontion while1ConsExprSE
      * return une Variable qui est une nouvelle variable
      */
     def trouveCondition(e:Expression): (List[Command],Expression,Variable)={
       e match{
          case Nl          => (Nil,e,Var("Nl"))
          case Cst(n)      => (Nil,e,Var(n))
          case VarExp(n)   => (Nil,e,Var(n))
          case _           => val x = while1ConsExprSE(e);val y = NewVar.make()
                              (x._1++List(Set(y,x._2)),x._2,y)
       }
     }
     
    command match{
      case Nop                 => List(Nop)
      case Set(v,e)            => val  x = while1ConsExprSE(e); x._1 ++ List(Set(v,x._2))
      
      case While(e,lc)         => {val  x = trouveCondition(e)
                                   // la condition est expression simple
                                   if(x._1 == Nil) x._1++List(While(trouveStr(x._3),while1ConsCommands(lc)))
                                   // la condition n'est pas simple, il faut ajouter cette condition dans la liste de commande pour terminer la boucle
                                   else x._1++List(While(trouveStr(x._3),while1ConsCommands(lc)++x._1))
                                  }
      
      case For(e,lc)           => {val  x = trouveCondition(e)
                                   x._1++List(For(trouveStr(x._3),while1ConsCommands(lc)))
                                  }
      
      case If(e,thenC,elseC)   => {val  x = trouveCondition(e)
                                   x._1++List(If(trouveStr(x._3),while1ConsCommands(thenC),while1ConsCommands(elseC)))
                                  }
    }
  }

  /**
   * @param commands : une liste non vide d'AST décrivant une liste non vide de commandes du langage WHILE
   * @return une liste de commandes ayant un seul constructeur par expression
   * et ayant le même effet que les commandes initiales
   */
  // TODO TP4
  def while1ConsCommands(commands: List[Command]): List[Command] = {
    commands match{
      case e::Nil => while1ConsCommand(e)
      case e::m   => while1ConsCommand(e) ++ while1ConsCommands(m)
    }
  }

  /**
   *
   *  TRAITEMENT DES PROGRAMMES DU LANGAGE WHILE
   */

  /**
   * @param program : un AST décrivant un programme du langage WHILE
   * @return un AST décrivant un programme du langage WHILE
   * de même sémantique que le programme initial mais ne contenant que des expressions simples
   */
  // TODO TP4
  def while1ConsProgr(program: Program): Program = {
    program match{
      case Progr(in, body, out) => if (in.length != 0 && out.length != 0) Progr(in,while1ConsCommands(body),out)
                                   else Progr(in,while1ConsCommands(Nil),out)
    }
  }

  def main(args: Array[String]): Unit = {

    // vous pouvez ici tester manuellement vos fonctions par des print
    println(while1ConsCommands(List(
          Set(Var("X"), Cons(VarExp("X"), VarExp("Y"))),
          Set(Var("X"), Cons(Tl(VarExp("Y")), Hd(VarExp("X")))))))
    println(while1ConsExprSE(Eq(VarExp("X"), Tl(VarExp("Y")))))

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
