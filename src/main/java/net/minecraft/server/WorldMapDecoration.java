package net.minecraft.server;

public class WorldMapDecoration {

   private byte type;
   private byte locX;
   private byte locY;
   private byte rotation;


   public WorldMapDecoration(byte var1, byte var2, byte var3, byte var4) {
      this.type = var1;
      this.locX = var2;
      this.locY = var3;
      this.rotation = var4;
   }

   public WorldMapDecoration(WorldMapDecoration var1) {
      this.type = var1.type;
      this.locX = var1.locX;
      this.locY = var1.locY;
      this.rotation = var1.rotation;
   }

   public byte getType() {
      return this.type;
   }

   public byte getLocX() {
      return this.locX;
   }

   public byte getLocY() {
      return this.locY;
   }

   public byte getRotation() {
      return this.rotation;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof WorldMapDecoration)) {
         return false;
      } else {
         WorldMapDecoration var2 = (WorldMapDecoration)var1;
         return this.type != var2.type?false:(this.rotation != var2.rotation?false:(this.locX != var2.locX?false:this.locY == var2.locY));
      }
   }

   public int hashCode() {
      byte var1 = this.type;
      int var2 = 31 * var1 + this.locX;
      var2 = 31 * var2 + this.locY;
      var2 = 31 * var2 + this.rotation;
      return var2;
   }
}
