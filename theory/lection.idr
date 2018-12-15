module Main

plus_z_c : (a : Nat) -> (0 + a) = (a + 0)
plus_z_c Z = Refl
plus_z_c (S k) = rewrite (plus_z_c k) in Refl 
