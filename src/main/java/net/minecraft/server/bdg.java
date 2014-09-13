package net.minecraft.server;

public class bdg extends bcm implements IUpdatePlayerListBox {

   private final aqi a = new bdh(this);


   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a.a(var1);
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      this.a.b(var1);
   }

   public void c() {
      this.a.c();
   }

   public Packet x_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      var1.o("SpawnPotentials");
      return new iu(this.c, 1, var1);
   }

   public boolean c(int var1, int var2) {
      return this.a.b(var1)?true:super.c(var1, var2);
   }

   public aqi b() {
      return this.a;
   }
}
