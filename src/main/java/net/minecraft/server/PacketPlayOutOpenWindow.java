package net.minecraft.server;

public class PacketPlayOutOpenWindow implements Packet {

   private int a;
   private String b;
   private IChatBaseComponent c;
   private int d;
   private int e;


   public PacketPlayOutOpenWindow() {}

   public PacketPlayOutOpenWindow(int var1, String var2, IChatBaseComponent var3) {
      this(var1, var2, var3, 0);
   }

   public PacketPlayOutOpenWindow(int var1, String var2, IChatBaseComponent var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public PacketPlayOutOpenWindow(int var1, String var2, IChatBaseComponent var3, int var4, int var5) {
      this(var1, var2, var3, var4);
      this.e = var5;
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readUnsignedByte();
      this.b = var1.c(32);
      this.c = var1.d();
      this.d = var1.readUnsignedByte();
      if(this.b.equals("EntityHorse")) {
         this.e = var1.readInt();
      }

   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.a);
      var1.a(this.b);
      var1.a(this.c);
      var1.writeByte(this.d);
      if(this.b.equals("EntityHorse")) {
         var1.writeInt(this.e);
      }

   }
}
