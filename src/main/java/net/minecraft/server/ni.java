package net.minecraft.server;
import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class ni implements Packet {

   private GameProfile a;


   public ni() {}

   public ni(GameProfile var1) {
      this.a = var1;
   }

   public void a(PacketDataSerializer var1) {
      this.a = new GameProfile((UUID)null, var1.c(16));
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a.getName());
   }

   public void a(PacketListener var1) {
      ((nh)var1).a(this);
   }

   public GameProfile a() {
      return this.a;
   }
}
