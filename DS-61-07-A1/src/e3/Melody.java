package e3;
import java.util.ArrayList;

public class Melody {
    enum Notes {DO, RE, MI, FA, SOL, LA, SI}
    enum Accidentals {NATURAL, SHARP,  FLAT}

    ArrayList<MusicalNote> notes = new ArrayList <>();

    /**
     * Creates an empty Melody instance .
     */
    public Melody () {
    }
    /**
     * Add a note at the end of this melody .
     * @param note The note to add
     * @param accidental The accidental of the note
     * @param time The duration of the note in milliseconds
     * @throws IllegalArgumentException if the note , the accidental
     * or the time are not valid values .
     */


    public void addNote ( Notes note , Accidentals accidental , float time ) {
        boolean isNote = false, isAccidental = false;
        for (Notes c : Notes.values())
            if (c == note) {
                isNote = true;
                break;
            }
        for (Accidentals c : Accidentals.values() )
            if (c == accidental) {
                isAccidental = true;
                break;
            }
        if( time > 0 && isNote && isAccidental ){
            MusicalNote noteNew = new MusicalNote(note, accidental, time);
            notes.add(noteNew);
        }else
            throw new IllegalArgumentException();
    }
    /**
     * Returns the note on the given position
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Notes getNote ( int index ) {
        if(index >= 0 && index < notes.size()){
            MusicalNote element = notes.get(index);
            return element.note();
        }else
            throw new IllegalArgumentException();
    }
    /**
     * Returns the accidental of the note on the given position
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Accidentals getAccidental (int index ) {
        if(index >= 0 && index < notes.size()){
            MusicalNote element = notes.get(index);
            return element.accidental();
        }else
            throw new IllegalArgumentException();
    }
    /**
     * Returns the duration of the note on the given position
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public float getTime ( int index ) {
        if(index >= 0 && index < notes.size()){
            MusicalNote element = notes.get(index);
            return element.time();
        }else
            throw new IllegalArgumentException();
    }
    /**
     * Returns the number of notes in this melody .
     * @return The number of notes in this melody .
     */
    public int size () {
        return notes.size();
    }
    /**
     * Returns the duration of this melody .
     * @return The duration of this melody in milliseconds .
     */
    public float getDuration () {
        float duration = 0;
        for (MusicalNote note : notes) {
            duration += note.time();
        }
        return duration;
    }
    /**
     * Performs the equality tests of the current melody with another melody
     * passed as a parameter . Two melodies are equal if they represent the same
     * music fragment regardless of the name of its notes .
     * @param o The melody to be compared with the current melody
     * @return true if the melodies are equals , false otherwise .
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        if(this.getDuration() != ((Melody) o).getDuration()) return false;
        if(this.size() != ((Melody) o).size()) return false;
        for (int i = 0; i < notes.size(); i++){
            MusicalNote thisElement = this.notes.get(i);
            MusicalNote oElement = ((Melody) o).notes.get(i);
            if(thisElement.time() != oElement.time())
                return false;
            if(oElement.note() != thisElement.note() || oElement.accidental() != thisElement.accidental()) {
                if (oElement.note() == Notes.DO){
                    if(oElement.accidental() == Accidentals.SHARP && (thisElement.note() != Notes.RE || thisElement.accidental() != Accidentals.FLAT))
                        return false;
                    else if(oElement.accidental() == Accidentals.NATURAL && (thisElement.note() != Notes.SI || thisElement.accidental() != Accidentals.SHARP))
                        return false;
                    else if(oElement.accidental() == Accidentals.FLAT && (thisElement.note() != Notes.SI || thisElement.accidental() != Accidentals.NATURAL))
                        return false;
                }else if (oElement.note() == Notes.RE){
                    if(oElement.accidental() == Accidentals.NATURAL)
                        return false;
                    else if(oElement.accidental() == Accidentals.SHARP && (thisElement.note() != Notes.MI || thisElement.accidental() != Accidentals.FLAT))
                        return false;
                    else if(oElement.accidental() == Accidentals.FLAT && (thisElement.note() != Notes.DO || thisElement.accidental() != Accidentals.SHARP))
                        return false;
                }else if (oElement.note() == Notes.MI){
                    if(oElement.accidental() == Accidentals.NATURAL && (thisElement.note() != Notes.FA || thisElement.accidental() != Accidentals.FLAT))
                        return false;
                    else if(oElement.accidental() == Accidentals.SHARP && (thisElement.note() != Notes.FA || thisElement.accidental() != Accidentals.NATURAL))
                        return false;
                    else if(oElement.accidental() == Accidentals.FLAT && (thisElement.note() != Notes.RE || thisElement.accidental() != Accidentals.SHARP))
                        return false;
                }else if (oElement.note() == Notes.FA){
                    if(oElement.accidental() == Accidentals.NATURAL && (thisElement.note() != Notes.MI || thisElement.accidental() != Accidentals.SHARP))
                        return false;
                    else if(oElement.accidental() == Accidentals.SHARP && (thisElement.note() != Notes.SOL || thisElement.accidental() != Accidentals.FLAT))
                        return false;
                    else if(oElement.accidental() == Accidentals.FLAT && (thisElement.note() != Notes.MI || thisElement.accidental() != Accidentals.NATURAL))
                        return false;
                }else if (oElement.note() == Notes.SOL){
                    if(oElement.accidental() == Accidentals.NATURAL)
                        return false;
                    else if(oElement.accidental() == Accidentals.SHARP && (thisElement.note() != Notes.LA || thisElement.accidental() != Accidentals.FLAT))
                        return false;
                    else if(oElement.accidental() == Accidentals.FLAT && (thisElement.note() != Notes.FA || thisElement.accidental() != Accidentals.SHARP))
                        return false;
                }else if (oElement.note() == Notes.LA){
                    if(oElement.accidental() == Accidentals.NATURAL)
                        return false;
                    else if(oElement.accidental() == Accidentals.SHARP && (thisElement.note() != Notes.SI || thisElement.accidental() != Accidentals.FLAT))
                        return false;
                    else if(oElement.accidental() == Accidentals.FLAT && (thisElement.note() != Notes.SOL || thisElement.accidental() != Accidentals.SHARP))
                        return false;
                }else if (oElement.note() == Notes.SI){
                    if(oElement.accidental() == Accidentals.NATURAL && (thisElement.note() != Notes.DO || thisElement.accidental() != Accidentals.FLAT))
                        return false;
                    else if(oElement.accidental() == Accidentals.SHARP && (thisElement.note() != Notes.DO || thisElement.accidental() != Accidentals.NATURAL))
                        return false;
                    else if(oElement.accidental() == Accidentals.FLAT && (thisElement.note() != Notes.LA || thisElement.accidental() != Accidentals.SHARP))
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns an integer that is a hash code representation of the melody .
     * Two melodies m1 , m2 that are equals (m1. equals (m2) == true ) must
     * have the same hash code .
     * @return The hash code of this melody .
     */
    @Override
    public int hashCode() {
        int result = 17;
        for (MusicalNote element : notes) {
            if ((element.note() == Notes.DO && element.accidental() == Accidentals.SHARP) || (element.note() == Notes.RE && element.accidental() == Accidentals.FLAT))
                result = 31 * result + 31 * 2;
            if ((element.note() == Notes.RE && element.accidental() == Accidentals.SHARP) || (element.note() == Notes.MI && element.accidental() == Accidentals.FLAT))
                result = 31 * result + 31 * 3;
            if ((element.note() == Notes.MI && element.accidental() == Accidentals.NATURAL) || (element.note() == Notes.FA && element.accidental() == Accidentals.FLAT))
                result = 31 * result + 31 * 4;
            if ((element.note() == Notes.MI && element.accidental() == Accidentals.SHARP) || (element.note() == Notes.FA && element.accidental() == Accidentals.NATURAL))
                result = 31 * result + 31 * 5;
            if ((element.note() == Notes.FA && element.accidental() == Accidentals.SHARP) || (element.note() == Notes.SOL && element.accidental() == Accidentals.FLAT))
                result = 31 * result + 31 * 6;
            if ((element.note() == Notes.SOL && element.accidental() == Accidentals.SHARP) || (element.note() == Notes.LA && element.accidental() == Accidentals.FLAT))
                result = 31 * result + 31 * 7;
            if ((element.note() == Notes.LA && element.accidental() == Accidentals.SHARP) || (element.note() == Notes.SI && element.accidental() == Accidentals.FLAT))
                result = 31 * result + 31 * 8;
            if ((element.note() == Notes.SI && element.accidental() == Accidentals.NATURAL) || (element.note() == Notes.DO && element.accidental() == Accidentals.FLAT))
                result = 31 * result + 31 * 9;
            if ((element.note() == Notes.SI && element.accidental() == Accidentals.SHARP) || (element.note() == Notes.DO && element.accidental() == Accidentals.NATURAL))
                result = 31 * result + 31 * 10;
            result = 31 * result + (int) element.time();
        }
        return result;
     }
    /**
     * The string representation of this melody .
     * @return The String representantion of this melody .
     */
    @Override
    public String toString() {

        StringBuilder strMelody = new StringBuilder();
        int i;

        for (i = 0; i < notes.size() - 1; i++) {
            MusicalNote thisElement = this.notes.get(i);
            strMelody.append(thisElement.note().toString());
            if (thisElement.accidental() == Accidentals.SHARP)
                strMelody.append("#");
            else if (thisElement.accidental() == Accidentals.FLAT)
                strMelody.append("b");
            strMelody.append("(").append(thisElement.time()).append(") ");
        }

        strMelody.append(this.notes.get(i).note());
        if (this.notes.get(i).accidental() == Accidentals.SHARP)
            strMelody.append("#");
        else if (this.notes.get(i).accidental() == Accidentals.FLAT)
            strMelody.append("b");
        strMelody.append("(").append(this.notes.get(i).time()).append(")");

        return strMelody.toString();
    }
}