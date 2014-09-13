package net.minecraft.server;

public class bcv extends TileEntity {

   private int a;


   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("OutputSignal", this.a);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = var1.getInt("OutputSignal");
   }

   public int b() {
      return this.a;
   }

   public void a(int var1) {
      this.a = var1;
   }
}
