module PlusSS

plusSS : (x : Nat) -> (S x) + S x = S (S (x + x))
plusSS Z = Refl
plusSS (S k) = 
    rewrite (plusSS k) in Refl
