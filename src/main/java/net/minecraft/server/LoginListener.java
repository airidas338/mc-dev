package net.minecraft.server;
import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;

import io.netty.util.concurrent.GenericFutureListener;

import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import javax.crypto.SecretKey;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginListener implements nh, IUpdatePlayerListBox {

   private static final AtomicInteger b = new AtomicInteger(0);
   private static final Logger c = LogManager.getLogger();
   private static final Random d = new Random();
   private final byte[] e = new byte[4];
   private final MinecraftServer f;
   public final NetworkManager a;
   private EnumProtocolState g;
   private int h;
   private GameProfile i;
   private String j;
   private SecretKey k;


   public LoginListener(MinecraftServer var1, NetworkManager var2) {
      this.g = EnumProtocolState.HELLO;
      this.j = "";
      this.f = var1;
      this.a = var2;
      d.nextBytes(this.e);
   }

   public void c() {
      if(this.g == EnumProtocolState.READY_TO_ACCEPT) {
         this.b();
      }

      if(this.h++ == 600) {
         this.a("Took too long to log in");
      }

   }

   public void a(String var1) {
      try {
         c.info("Disconnecting " + this.d() + ": " + var1);
         ChatComponentText var2 = new ChatComponentText(var1);
         this.a.a((Packet)(new ng(var2)));
         this.a.a((IChatBaseComponent)var2);
      } catch (Exception var3) {
         c.error("Error whilst disconnecting player", var3);
      }

   }

   public void b() {
      if(!this.i.isComplete()) {
         this.i = this.a(this.i);
      }

      String var1 = this.f.an().a(this.a.b(), this.i);
      if(var1 != null) {
         this.a(var1);
      } else {
         this.g = EnumProtocolState.ACCEPTED;
         if(this.f.aI() >= 0 && !this.a.c()) {
            this.a.a(new nf(this.f.aI()), new rr(this), new GenericFutureListener[0]);
         }

         this.a.a((Packet)(new nd(this.i)));
         this.f.an().a(this.a, this.f.an().f(this.i));
      }

   }

   public void a(IChatBaseComponent var1) {
      c.info(this.d() + " lost connection: " + var1.c());
   }

   public String d() {
      return this.i != null?this.i.toString() + " (" + this.a.b().toString() + ")":String.valueOf(this.a.b());
   }

   public void a(ni var1) {
      Validate.validState(this.g == EnumProtocolState.HELLO, "Unexpected hello packet", new Object[0]);
      this.i = var1.a();
      if(this.f.ae() && !this.a.c()) {
         this.g = EnumProtocolState.KEY;
         this.a.a((Packet)(new ne(this.j, this.f.P().getPublic(), this.e)));
      } else {
         this.g = EnumProtocolState.READY_TO_ACCEPT;
      }

   }

   public void a(nj var1) {
      Validate.validState(this.g == EnumProtocolState.KEY, "Unexpected key packet", new Object[0]);
      PrivateKey var2 = this.f.P().getPrivate();
      if(!Arrays.equals(this.e, var1.b(var2))) {
         throw new IllegalStateException("Invalid nonce!");
      } else {
         this.k = var1.a(var2);
         this.g = EnumProtocolState.AUTHENTICATING;
         this.a.a(this.k);
         (new ThreadPlayerLookupUUID(this, "User Authenticator #" + b.incrementAndGet())).start();
      }
   }

   protected GameProfile a(GameProfile var1) {
      UUID var2 = UUID.nameUUIDFromBytes(("OfflinePlayer:" + var1.getName()).getBytes(Charsets.UTF_8));
      return new GameProfile(var2, var1.getName());
   }

   // $FF: synthetic method
   static MinecraftServer a(LoginListener var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static GameProfile b(LoginListener var0) {
      return var0.i;
   }

   // $FF: synthetic method
   static String c(LoginListener var0) {
      return var0.j;
   }

   // $FF: synthetic method
   static SecretKey d(LoginListener var0) {
      return var0.k;
   }

   // $FF: synthetic method
   static GameProfile a(LoginListener var0, GameProfile var1) {
      return var0.i = var1;
   }

   // $FF: synthetic method
   static Logger e() {
      return c;
   }

   // $FF: synthetic method
   static EnumProtocolState a(LoginListener var0, EnumProtocolState var1) {
      return var0.g = var1;
   }

}
