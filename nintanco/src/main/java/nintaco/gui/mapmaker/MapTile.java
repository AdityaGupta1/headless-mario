package nintaco.gui.mapmaker;

public class MapTile {

  private byte[] paletteIndices;
  private boolean edgeTile;

  public void setPaletteIndices(byte[] paletteIndices) {
    this.paletteIndices = paletteIndices;
  }

  public void setEdgeTile(boolean edgeTile) {
    this.edgeTile = edgeTile;
  }
  
  public byte[] getPaletteIndices() {
    return paletteIndices;
  }

  public boolean isEdgeTile() {
    return edgeTile;
  }
}
