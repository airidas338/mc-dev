package net.minecraft.server;
import com.mojang.authlib.GameProfile;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class pn extends PlayerList {

   private static final Logger h = LogManager.getLogger();


   public pn(DedicatedServer var1) {
      super(var1);
      this.a(var1.a("view-distance", 10));
      this.g = var1.a("max-players", 20);
      this.a(var1.a("white-list", false));
      if(!var1.S()) {
         this.i().a(true);
         this.j().a(true);
      }

      this.z();
      this.x();
      this.y();
      this.w();
      this.A();
      this.C();
      this.B();
      if(!this.l().c().exists()) {
         this.D();
      }

   }

   public void a(boolean var1) {
      super.a(var1);
      this.b().a("white-list", (Object)Boolean.valueOf(var1));
      this.b().a();
   }

   public void a(GameProfile var1) {
      super.a(var1);
      this.B();
   }

   public void b(GameProfile var1) {
      super.b(var1);
      this.B();
   }

   public void c(GameProfile var1) {
      super.c(var1);
      this.D();
   }

   public void d(GameProfile var1) {
      super.d(var1);
      this.D();
   }

   public void a() {
      this.C();
   }

   private void w() {
      try {
         this.j().f();
      } catch (IOException var2) {
         h.warn("Failed to save ip banlist: ", var2);
      }

   }

   private void x() {
      try {
         this.i().f();
      } catch (IOException var2) {
         h.warn("Failed to save user banlist: ", var2);
      }

   }

   private void y() {
      try {
         this.j().g();
      } catch (IOException var2) {
         h.warn("Failed to load ip banlist: ", var2);
      }

   }

   private void z() {
      try {
         this.i().g();
      } catch (IOException var2) {
         h.warn("Failed to load user banlist: ", var2);
      }

   }

   private void A() {
      try {
         this.n().g();
      } catch (Exception var2) {
         h.warn("Failed to load operators list: ", var2);
      }

   }

   private void B() {
      try {
         this.n().f();
      } catch (Exception var2) {
         h.warn("Failed to save operators list: ", var2);
      }

   }

   private void C() {
      try {
         this.l().g();
      } catch (Exception var2) {
         h.warn("Failed to load white-list: ", var2);
      }

   }

   private void D() {
      try {
         this.l().f();
      } catch (Exception var2) {
         h.warn("Failed to save white-list: ", var2);
      }

   }

   public boolean e(GameProfile var1) {
      return !this.s() || this.g(var1) || this.l().a(var1);
   }

   public DedicatedServer b() {
      return (DedicatedServer)super.c();
   }

   // $FF: synthetic method
   public MinecraftServer c() {
      return this.b();
   }

}
