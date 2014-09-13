package net.minecraft.server;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bs extends CommandAbstract {

   public String c() {
      return "help";
   }

   public int a() {
      return 0;
   }

   public String c(ICommandSender var1) {
      return "commands.help.usage";
   }

   public List b() {
      return Arrays.asList(new String[]{"?"});
   }

   public void a(ICommandSender var1, String[] var2) throws di {
      List var3 = this.d(var1);
      boolean var4 = true;
      int var5 = (var3.size() - 1) / 7;
      boolean var6 = false;

      int var13;
      try {
         var13 = var2.length == 0?0:a(var2[0], 1, var5 + 1) - 1;
      } catch (dk var12) {
         Map var8 = this.d();
         ac var9 = (ac)var8.get(var2[0]);
         if(var9 != null) {
            throw new dp(var9.c(var1), new Object[0]);
         }

         if(MathHelper.a(var2[0], -1) != -1) {
            throw var12;
         }

         throw new dn();
      }

      int var7 = Math.min((var13 + 1) * 7, var3.size());
      ChatMessage var14 = new ChatMessage("commands.help.header", new Object[]{Integer.valueOf(var13 + 1), Integer.valueOf(var5 + 1)});
      var14.b().a(EnumChatFormat.c);
      var1.a(var14);

      for(int var15 = var13 * 7; var15 < var7; ++var15) {
         ac var10 = (ac)var3.get(var15);
         ChatMessage var11 = new ChatMessage(var10.c(var1), new Object[0]);
         var11.b().a(new hm(hn.e, "/" + var10.c() + " "));
         var1.a(var11);
      }

      if(var13 == 0 && var1 instanceof EntityHuman) {
         ChatMessage var16 = new ChatMessage("commands.help.footer", new Object[0]);
         var16.b().a(EnumChatFormat.k);
         var1.a(var16);
      }

   }

   protected List d(ICommandSender var1) {
      List var2 = MinecraftServer.M().O().a(var1);
      Collections.sort(var2);
      return var2;
   }

   protected Map d() {
      return MinecraftServer.M().O().a();
   }

   public List a(ICommandSender var1, String[] var2, Location var3) {
      if(var2.length == 1) {
         Set var4 = this.d().keySet();
         return a(var2, (String[])var4.toArray(new String[var4.size()]));
      } else {
         return null;
      }
   }
}
