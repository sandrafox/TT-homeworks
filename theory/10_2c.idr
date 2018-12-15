module Plus_s

plus_s : (x : Nat) -> S x = x + 1
plus_s Z = Refl
plus_s (S k) = cong (plus_s k)
