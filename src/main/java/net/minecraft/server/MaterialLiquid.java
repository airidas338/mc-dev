package net.minecraft.server;

public class MaterialLiquid extends Material {

   public MaterialLiquid(MaterialMapColor var1) {
      super(var1);
      this.i();
      this.n();
   }

   public boolean isLiquid() {
      return true;
   }

   public boolean isSolid() {
      return false;
   }

   public boolean isBuildable() {
      return false;
   }
}
