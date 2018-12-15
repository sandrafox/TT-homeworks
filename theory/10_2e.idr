module PlusAssoc

plusA : (x : Nat) -> (y : Nat) -> (z : Nat) -> x + (y + z) = (x + y) + z
plusA Z y z = Refl
plusA (S x) y z = rewrite (plusA x y z) in Refl 
