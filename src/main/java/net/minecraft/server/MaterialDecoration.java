package net.minecraft.server;

public class MaterialDecoration extends Material {

   public MaterialDecoration(MaterialMapColor var1) {
      super(var1);
      this.p();
   }

   public boolean isBuildable() {
      return false;
   }

   public boolean blocksLight() {
      return false;
   }

   public boolean isSolid() {
      return false;
   }
}
