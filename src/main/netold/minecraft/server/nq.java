package net.minecraft.server;
import com.mojang.authlib.GameProfile;

public class nq {

   private final int a;
   private final int b;
   private GameProfile[] c;


   public nq(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   public GameProfile[] c() {
      return this.c;
   }

   public void a(GameProfile[] var1) {
      this.c = var1;
   }
}
