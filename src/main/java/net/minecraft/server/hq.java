package net.minecraft.server;
import java.util.Iterator;
import java.util.List;

public class hq {

   public static IChatBaseComponent a(ICommandListener var0, IChatBaseComponent var1, Entity var2) throws ExceptionInvalidUUID {
      Object var3 = null;
      if(var1 instanceof ht) {
         ht var4 = (ht)var1;
         String var5 = var4.g();
         if(ah.b(var5)) {
            List var6 = ah.b(var0, var5, Entity.class);
            if(var6.size() != 1) {
               throw new ExceptionInvalidUUID();
            }

            var5 = ((Entity)var6.get(0)).getName();
         }

         var3 = var2 != null && var5.equals("*")?new ht(var2.getName(), var4.h()):new ht(var5, var4.h());
         ((ht)var3).b(var4.e());
      } else if(var1 instanceof hu) {
         String var7 = ((hu)var1).g();
         var3 = ah.b(var0, var7);
         if(var3 == null) {
            var3 = new ChatComponentText("");
         }
      } else if(var1 instanceof ChatComponentText) {
         var3 = new ChatComponentText(((ChatComponentText)var1).g());
      } else {
         if(!(var1 instanceof ChatMessage)) {
            return var1;
         }

         Object[] var8 = ((ChatMessage)var1).j();

         for(int var11 = 0; var11 < var8.length; ++var11) {
            Object var12 = var8[var11];
            if(var12 instanceof IChatBaseComponent) {
               var8[var11] = a(var0, (IChatBaseComponent)var12, var2);
            }
         }

         var3 = new ChatMessage(((ChatMessage)var1).i(), var8);
      }

      ChatModifier var9 = var1.getChatModifier();
      if(var9 != null) {
         ((IChatBaseComponent)var3).setChatModifier(var9.m());
      }

      Iterator var13 = var1.a().iterator();

      while(var13.hasNext()) {
         IChatBaseComponent var10 = (IChatBaseComponent)var13.next();
         ((IChatBaseComponent)var3).a(a(var0, var10, var2));
      }

      return (IChatBaseComponent)var3;
   }
}
