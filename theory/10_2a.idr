module Main

plusZ : (x : Nat) -> x = x + 0
plusZ Z = Refl
plusZ (S k) = rewrite (plusZ k) in Refl
 
