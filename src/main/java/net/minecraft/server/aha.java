package net.minecraft.server;

public class aha {

   public boolean a;
   public boolean b;
   public boolean c;
   public boolean d;
   public boolean e = true;
   private float f = 0.05F;
   private float g = 0.1F;


   public void a(NBTTagCompound var1) {
      NBTTagCompound var2 = new NBTTagCompound();
      var2.setBoolean("invulnerable", this.a);
      var2.setBoolean("flying", this.b);
      var2.setBoolean("mayfly", this.c);
      var2.setBoolean("instabuild", this.d);
      var2.setBoolean("mayBuild", this.e);
      var2.setFloat("flySpeed", this.f);
      var2.setFloat("walkSpeed", this.g);
      var1.set("abilities", (NBTBase)var2);
   }

   public void b(NBTTagCompound var1) {
      if(var1.hasKeyOfType("abilities", 10)) {
         NBTTagCompound var2 = var1.getCompound("abilities");
         this.a = var2.getBoolean("invulnerable");
         this.b = var2.getBoolean("flying");
         this.c = var2.getBoolean("mayfly");
         this.d = var2.getBoolean("instabuild");
         if(var2.hasKeyOfType("flySpeed", 99)) {
            this.f = var2.getFloat("flySpeed");
            this.g = var2.getFloat("walkSpeed");
         }

         if(var2.hasKeyOfType("mayBuild", 1)) {
            this.e = var2.getBoolean("mayBuild");
         }
      }

   }

   public float a() {
      return this.f;
   }

   public float b() {
      return this.g;
   }
}
