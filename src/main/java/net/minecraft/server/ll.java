package net.minecraft.server;

public class ll implements Packet {

   private World a;
   private Location b;
   private IChatBaseComponent[] c;


   public ll() {}

   public ll(World var1, Location var2, IChatBaseComponent[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = new IChatBaseComponent[]{var3[0], var3[1], var3[2], var3[3]};
   }

   public void a(hd var1) {
      this.b = var1.c();
      this.c = new IChatBaseComponent[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         this.c[var2] = var1.d();
      }

   }

   public void b(hd var1) {
      var1.a(this.b);

      for(int var2 = 0; var2 < 4; ++var2) {
         var1.a(this.c[var2]);
      }

   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
