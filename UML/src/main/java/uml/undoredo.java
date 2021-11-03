package uml;

import java.util.*;


public class undoredo {
    public static ArrayList<String> mem = new ArrayList<String>();
    //private Iterator<String> itr = mem.iterator();
    private static ArrayList<UML> newColl = new ArrayList<UML>();
    static int incr = 0;
   

    public static void stateKeeper(){ 
        mem.add(incr,JsonFile.save(Model.getCollection())); // adds the string of the save file into an arraylist to track actions
       //System.out.println(mem.size());
    //    System.out.println(Model.getCollection().size());
        ++incr;
       //System.out.println("incr: "+ incr);
        
    
    }

    public static void undo(){
        try {
            --incr;
            JsonFile.load(mem.get(incr-1), newColl); //returns to a previous save by loading prev coll 
            System.out.println("Action undone!");
            //System.out.println(mem.size());
            //System.out.println("incr: "+ incr);
        
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nothing left to undo!");
        }
        

    }
    public static void redo(){
        try {
            
            JsonFile.load(mem.get(incr), newColl); //redoes an undone action
            ++incr;
            
            System.out.println("Action redone!");
            //System.out.println(mem.size());
            //System.out.println("incr: "+ incr);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nothing left to redo!");
        }
        

    }
    
    public static void memClear(){ // if method is called after undo/redo clear any replace index and clear all indices after
        int temp = incr;
        int hold = mem.size();
        try{
            for (int i = temp; i <= hold-1; ++i){ //clears history of collection when an action is taken after undo/redo

                mem.remove(mem.get(incr));
            }

            //System.err.println("blep");
            //System.out.println(mem.size());
            //System.out.println("incr: "+ incr);
        }
        catch (IndexOutOfBoundsException e){
           System.out.println(e.getMessage());
        }


    }
    public static void loadClear(){
        mem.clear();
        stateKeeper();
        incr = 0;
        
    }
}