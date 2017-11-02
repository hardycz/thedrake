package budha.thedrake;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class StandardDrakeSetup implements TheDrakeSetup {
    //TODO
    /*
        Do třídy StandardDrakeSetup přidejte hash mapu
        mapující jména jednotek na jejich info a pomocí ní implementujte metodu infoByName().
        Pokud infoByName dostane řetězěc, který není platným názvem jednotky, vyhodí výjimku IllegalArgumentException.
     */
    @Override
    public TroopInfo infoByName(String name) {
        TroopInfo troop = hashMap.get(name);
        if(troop == null) throw new IllegalArgumentException();
        return troop;
    }

    @Override
    public List<TroopInfo> troops() {
        return Arrays.asList(DRAKE, CLUBMAN, MONK, SPEARMAN, SWORDSMAN, ARCHER);
    }

    public final HashMap<String,TroopInfo> hashMap = createMap();

    public HashMap createMap(){
        HashMap<String,TroopInfo> hashMap = new HashMap<>();
        for(TroopInfo troop: troops()){
                String test = troop.name();
                hashMap.put(troop.name(),troop);
            }
        return hashMap;
    }


    public static final TroopInfo DRAKE = new TroopInfo(
            "Drake",
            Arrays.asList(
                    new SlideAction(1, 0),
                    new SlideAction(-1, 0)),
            Arrays.asList(
                    new SlideAction(0, 1),
                    new SlideAction(0, -1)));

    public static final TroopInfo CLUBMAN = new TroopInfo(
            "Clubman",
            Arrays.asList(
                    new ShiftAction(1, 0),
                    new ShiftAction(0, 1),
                    new ShiftAction(-1, 0),
                    new ShiftAction(0, -1)),
            Arrays.asList(
                    new ShiftAction(1, 1),
                    new ShiftAction(-1, 1),
                    new ShiftAction(1, -1),
                    new ShiftAction(-1, -1)));

    public static final TroopInfo MONK = new TroopInfo(
            "Monk",
            Arrays.asList(
                    new SlideAction(1, 1),
                    new SlideAction(-1, 1),
                    new SlideAction(1, -1),
                    new SlideAction(-1, -1)),
            Arrays.asList(
                    new ShiftAction(1, 0),
                    new ShiftAction(0, 1),
                    new ShiftAction(-1, 0),
                    new ShiftAction(0, -1)));

    public static final TroopInfo SPEARMAN = new TroopInfo(
            "Spearman",
            Arrays.asList(
                    new ShiftAction(0, 1),
                    new StrikeAction(1, 2),
                    new StrikeAction(-1, 2)),
            Arrays.asList(
                    new ShiftAction(1, 1),
                    new ShiftAction(-1, 1),
                    new ShiftAction(0, -1)));

    public static final TroopInfo SWORDSMAN = new TroopInfo(
            "Swordsman",
            Arrays.asList(
                    new StrikeAction(1, 0),
                    new StrikeAction(0, 1),
                    new StrikeAction(-1, 0),
                    new StrikeAction(0, -1)),
            Arrays.asList(
                    new ShiftAction(1, 0),
                    new ShiftAction(0, 1),
                    new ShiftAction(-1, 0),
                    new ShiftAction(0, -1)));

    public static final TroopInfo ARCHER = new TroopInfo(
            "Archer",
            new Offset2D(1, 1),
            new Offset2D(1, 0),
            Arrays.asList(
                    new ShiftAction(1, 0),
                    new ShiftAction(-1, 0),
                    new ShiftAction(0, -1)),
            Arrays.asList(
                    new ShiftAction(0, 1),
                    new StrikeAction(-1, 1),
                    new StrikeAction(1, 1),
                    new StrikeAction(0, 2)));


}