package fr.istic.si2.adnmatch

import fr.istic.si2.scribble._
import fr.istic.si2.adnmatch._
import fr.istic.si2.adnmatch.FonctionsRExp._
import fr.istic.si2.adnmatchlib._

/**
 * Application ADNMatch version 1.
 */
object ADNMatchV1 extends App {

  println("ADNMatch Version 1")
  // TODO V1 - A compléter
  val list1 : List[Base] = A::G::T::Nil
  val list2 : List[Base] = A::Nil
  val list3 : List[Base] = T::Nil
  val list4 : List[Base] = G::C::Nil
  val rexp1 : RExp = Choix(UneBase(A),UneBase(G))
  val rexp2 : RExp = Nqb
  val rexp3 : RExp = Concat(UneBase(A),Choix(UneBase(T),UneBase(G)))
  val rexp4 : RExp = Repete(rexp1)
  val rexp5 : RExp = NFois(rexp1,2)
  println(listeBasesToString(list1))
  println(rExpToString(rexp1))
  println(rExpToString(rexp3))
  println(rExpToString(rexp4))
  println(rExpToString(rexp5))
  println(litRExp(rExpToString(rexp1)))
  println(litRExp(rExpToString(rexp3)))
  println(litRExp(rExpToString(rexp2)))
  println(litRExp(rExpToString(rexp4)))
  println(litRExp(rExpToString(rexp5)))
}