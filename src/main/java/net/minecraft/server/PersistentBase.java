package net.minecraft.server;

public abstract class PersistentBase {

   public final String id;
   private boolean b;


   public PersistentBase(String var1) {
      this.id = var1;
   }

   public abstract void a(NBTTagCompound var1);

   public abstract void b(NBTTagCompound var1);

   public void c() {
      this.a(true);
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public boolean d() {
      return this.b;
   }
}
