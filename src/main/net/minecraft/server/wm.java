package net.minecraft.server;



public class wm extends wp {

   protected wm(int var1, RegistryMaterials var2, boolean var3, int var4) {
      super(var1, var2, var3, var4);
   }

   public double a(int var1, ya var2) {
      return this.H == wp.t.H?(double)(-0.5F * (float)(var1 + 1)):1.3D * (double)(var1 + 1);
   }
}
