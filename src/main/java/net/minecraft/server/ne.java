package net.minecraft.server;
import java.security.PublicKey;

public class ne implements Packet {

   private String a;
   private PublicKey b;
   private byte[] c;


   public ne() {}

   public ne(String var1, PublicKey var2, byte[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.c(20);
      this.b = MinecraftEncryption.a(var1.a());
      this.c = var1.a();
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
      var1.a(this.b.getEncoded());
      var1.a(this.c);
   }

   public void a(PacketListener var1) {
      ((nc)var1).a(this);
   }
}
