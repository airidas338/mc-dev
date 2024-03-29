package net.minecraft.server;
import java.util.List;

public class PacketPlayOutMapChunkBulk implements Packet {

   private int[] a;
   private int[] b;
   private jr[] c;
   private boolean d;


   public PacketPlayOutMapChunkBulk() {}

   public PacketPlayOutMapChunkBulk(List var1) {
      int var2 = var1.size();
      this.a = new int[var2];
      this.b = new int[var2];
      this.c = new jr[var2];
      this.d = !((Chunk)var1.get(0)).p().worldProvider.o();

      for(int var3 = 0; var3 < var2; ++var3) {
         Chunk var4 = (Chunk)var1.get(var3);
         jr var5 = PacketPlayOutMapChunk.a(var4, true, this.d, '\uffff');
         this.a[var3] = var4.a;
         this.b[var3] = var4.b;
         this.c[var3] = var5;
      }

   }

   public void a(PacketDataSerializer var1) {
      this.d = var1.readBoolean();
      int var2 = var1.e();
      this.a = new int[var2];
      this.b = new int[var2];
      this.c = new jr[var2];

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         this.a[var3] = var1.readInt();
         this.b[var3] = var1.readInt();
         this.c[var3] = new jr();
         this.c[var3].b = var1.readShort() & '\uffff';
         this.c[var3].a = new byte[PacketPlayOutMapChunk.a(Integer.bitCount(this.c[var3].b), this.d, true)];
      }

      for(var3 = 0; var3 < var2; ++var3) {
         var1.readBytes(this.c[var3].a);
      }

   }

   public void b(PacketDataSerializer var1) {
      var1.writeBoolean(this.d);
      var1.b(this.c.length);

      int var2;
      for(var2 = 0; var2 < this.a.length; ++var2) {
         var1.writeInt(this.a[var2]);
         var1.writeInt(this.b[var2]);
         var1.writeShort((short)(this.c[var2].b & '\uffff'));
      }

      for(var2 = 0; var2 < this.a.length; ++var2) {
         var1.writeBytes(this.c[var2].a);
      }

   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
