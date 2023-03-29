enum Figura {
  CORAZONES("♥"),
  PICAS("♠"),
  DIAMANTES("♦"),
  TREBOLES("♣");
  
  private String rawValue;

  private Figura(String rawValue) {
	  this.rawValue = rawValue;
  }
  
  public String rawValue() {
	  return rawValue;
  }
}
