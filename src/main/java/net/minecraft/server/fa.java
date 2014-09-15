package net.minecraft.server;

public class fa {

   protected final float a;
   protected final float b;
   protected final float c;


   public fa(float var1, float var2, float var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public fa(NBTTagList var1) {
      this.a = var1.e(0);
      this.b = var1.e(1);
      this.c = var1.e(2);
   }

   public NBTTagList a() {
      NBTTagList var1 = new NBTTagList();
      var1.add((NBTBase)(new NBTTagFloat(this.a)));
      var1.add((NBTBase)(new NBTTagFloat(this.b)));
      var1.add((NBTBase)(new NBTTagFloat(this.c)));
      return var1;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof fa)) {
         return false;
      } else {
         fa var2 = (fa)var1;
         return this.a == var2.a && this.b == var2.b && this.c == var2.c;
      }
   }

   public float b() {
      return this.a;
   }

   public float c() {
      return this.b;
   }

   public float d() {
      return this.c;
   }
}
