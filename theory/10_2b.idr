module PlusS

plusS : (x : Nat) -> S x = 1 + x
plusS Z = Refl 
plusS (S k) = cong (plusS k) 
