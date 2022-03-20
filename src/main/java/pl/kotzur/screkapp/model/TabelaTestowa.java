package pl.kotzur.screkapp.model;


public class TabelaTestowa {

  private long id;
  private String kolumna1;
  private String kolumna2;
  private String kolumna3;
  private long kolumna4;

  public TabelaTestowa(long id, String kolumna1, String kolumna2, String kolumna3, long kolumna4) {
    this.id = id;
    this.kolumna1 = kolumna1;
    this.kolumna2 = kolumna2;
    this.kolumna3 = kolumna3;
    this.kolumna4 = kolumna4;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getKolumna1() {
    return kolumna1;
  }

  public void setKolumna1(String kolumna1) {
    this.kolumna1 = kolumna1;
  }


  public String getKolumna2() {
    return kolumna2;
  }

  public void setKolumna2(String kolumna2) {
    this.kolumna2 = kolumna2;
  }


  public String getKolumna3() {
    return kolumna3;
  }

  public void setKolumna3(String kolumna3) {
    this.kolumna3 = kolumna3;
  }


  public long getKolumna4() {
    return kolumna4;
  }

  public void setKolumna4(long kolumna4) {
    this.kolumna4 = kolumna4;
  }

}
