class Wind extends Instrument {
  void play(Note n) { System.out.println("Wind.play() " + n); }
  String what() { return "Wind"; }
  void adjust() { System.out.println("Adjusting Wind"); }
}
