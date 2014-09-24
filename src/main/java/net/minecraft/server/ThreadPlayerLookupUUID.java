package net.minecraft.server;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import java.math.BigInteger;
import java.util.UUID;

class ThreadPlayerLookupUUID extends Thread {

   // $FF: synthetic field
   final LoginListener a;


   ThreadPlayerLookupUUID(LoginListener var1, String var2) {
      super(var2);
      this.a = var1;
   }

   public void run() {
      GameProfile var1 = LoginListener.b(this.a);

      try {
         String var2 = (new BigInteger(MinecraftEncryption.a(LoginListener.c(this.a), LoginListener.a(this.a).P().getPublic(), LoginListener.d(this.a)))).toString(16);
         LoginListener.a(this.a, LoginListener.a(this.a).aB().hasJoinedServer(new GameProfile((UUID)null, var1.getName()), var2));
         if(LoginListener.b(this.a) != null) {
            LoginListener.e().info("UUID of player " + LoginListener.b(this.a).getName() + " is " + LoginListener.b(this.a).getId());
            LoginListener.a(this.a, EnumProtocolState.READY_TO_ACCEPT);
         } else if(LoginListener.a(this.a).S()) {
            LoginListener.e().warn("Failed to verify username but will let them in anyway!");
            LoginListener.a(this.a, this.a.a(var1));
            LoginListener.a(this.a, EnumProtocolState.READY_TO_ACCEPT);
         } else {
            this.a.a("Failed to verify username!");
            LoginListener.e().error("Username \'" + LoginListener.b(this.a).getName() + "\' tried to join with an invalid session");
         }
      } catch (AuthenticationUnavailableException var3) {
         if(LoginListener.a(this.a).S()) {
            LoginListener.e().warn("Authentication servers are down but will let them in anyway!");
            LoginListener.a(this.a, this.a.a(var1));
            LoginListener.a(this.a, EnumProtocolState.READY_TO_ACCEPT);
         } else {
            this.a.a("Authentication servers are down. Please try again later, sorry!");
            LoginListener.e().error("Couldn\'t verify username because servers are unavailable");
         }
      }

   }
}
