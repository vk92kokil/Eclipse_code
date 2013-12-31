
public class Music3 {
  public static void tune(Instrument i) {
    i.play(Note.MIDDLE_C);
  }
  public static void main(String[] args) {
    Instrument[] orchestra = {
      new Wind(),
      new Percussion(),
      new Stringed(),
      new Brass(),
      new Woodwind()
    };
    //TuneAll
    for(Instrument i : orchestra)
      tune(i);
  }
} 