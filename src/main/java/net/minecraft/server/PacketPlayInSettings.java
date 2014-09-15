package net.minecraft.server;

public class PacketPlayInSettings implements Packet {

   private String a;
   private int b;
   private EnumChatVisibility c;
   private boolean d;
   private int e;


   public void a(PacketDataSerializer var1) {
      this.a = var1.c(7);
      this.b = var1.readByte();
      this.c = EnumChatVisibility.a(var1.readByte());
      this.d = var1.readBoolean();
      this.e = var1.readUnsignedByte();
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
      var1.writeByte(this.b);
      var1.writeByte(this.c.a());
      var1.writeBoolean(this.d);
      var1.writeByte(this.e);
   }

   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public String a() {
      return this.a;
   }

   public EnumChatVisibility c() {
      return this.c;
   }

   public boolean d() {
      return this.d;
   }

   public int e() {
      return this.e;
   }
}
