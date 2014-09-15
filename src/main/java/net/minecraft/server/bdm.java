package net.minecraft.server;
import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import java.util.UUID;

public class bdm extends TileEntity {

   private int a;
   private int f;
   private GameProfile g = null;


   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setByte("SkullType", (byte)(this.a & 255));
      var1.setByte("Rot", (byte)(this.f & 255));
      if(this.g != null) {
         NBTTagCompound var2 = new NBTTagCompound();
         GameProfileSerializer.serialize(var2, this.g);
         var1.set("Owner", (NBTBase)var2);
      }

   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = var1.getByte("SkullType");
      this.f = var1.getByte("Rot");
      if(this.a == 3) {
         if(var1.hasKeyOfType("Owner", 10)) {
            this.g = GameProfileSerializer.deserialize(var1.getCompound("Owner"));
         } else if(var1.hasKeyOfType("ExtraType", 8)) {
            String var2 = var1.getString("ExtraType");
            if(!vb.b(var2)) {
               this.g = new GameProfile((UUID)null, var2);
               this.e();
            }
         }
      }

   }

   public GameProfile b() {
      return this.g;
   }

   public Packet x_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      return new iu(this.c, 4, var1);
   }

   public void a(int var1) {
      this.a = var1;
      this.g = null;
   }

   public void a(GameProfile var1) {
      this.a = 3;
      this.g = var1;
      this.e();
   }

   private void e() {
      this.g = b(this.g);
      this.o_();
   }

   public static GameProfile b(GameProfile var0) {
      if(var0 != null && !vb.b(var0.getName())) {
         if(var0.isComplete() && var0.getProperties().containsKey("textures")) {
            return var0;
         } else if(MinecraftServer.M() == null) {
            return var0;
         } else {
            GameProfile var1 = MinecraftServer.M().aD().a(var0.getName());
            if(var1 == null) {
               return var0;
            } else {
               Property var2 = (Property)Iterables.getFirst(var1.getProperties().get("textures"), (Object)null);
               if(var2 == null) {
                  var1 = MinecraftServer.M().aB().fillProfileProperties(var1, true);
               }

               return var1;
            }
         }
      } else {
         return var0;
      }
   }

   public int c() {
      return this.a;
   }

   public void b(int var1) {
      this.f = var1;
   }
}
