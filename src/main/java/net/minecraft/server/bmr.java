package net.minecraft.server;

public class bmr extends bqc {

   private NBTTagCompound b = new NBTTagCompound();


   public bmr(String var1) {
      super(var1);
   }

   public void a(NBTTagCompound var1) {
      this.b = var1.m("Features");
   }

   public void b(NBTTagCompound var1) {
      var1.a("Features", (NBTBase)this.b);
   }

   public void a(NBTTagCompound var1, int var2, int var3) {
      this.b.a(b(var2, var3), (NBTBase)var1);
   }

   public static String b(int var0, int var1) {
      return "[" + var0 + "," + var1 + "]";
   }

   public NBTTagCompound a() {
      return this.b;
   }
}
