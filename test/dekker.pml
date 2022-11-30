byte spin = 1;
boolean wantP = false;
boolean wantQ = false;

active proctype P() {
    do 
        :: wantP = true;
        do
            :: !wantQ -> break
            :: else ->
                if 
                    :: turn == 2 ->
                        wantP = false;
                        do  /* await (turn==1) */
                            :: turn2 == 2 -> break
                            :: else -> skip
                        od;
                        wantP -> true;
                    :: else
                fi
            od;
            c++;
            assert (c==1);
            c--;
            wantP = false
    od
}


active proctype Q() {
    do 
        :: wantQ = true;
        do
            :: !wantP -> break
            :: else ->
                if 
                    :: turn == 2 ->
                        wantQ = false;
                        do
                            :: turn2 == 2 -> break
                            :: else -> skip

                        od;
                        wantQ -> true;
                    :: else
                fi
            od;
            c++;
            assert (c==1);
            c--;
            wantQ = false
    od
}
