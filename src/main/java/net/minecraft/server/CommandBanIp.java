package net.minecraft.server;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandBanIp extends CommandAbstract {

   public static final Pattern a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");


   public String getCommand() {
      return "ban-ip";
   }

   public int a() {
      return 3;
   }

   public boolean canUse(ICommandListener var1) {
      return MinecraftServer.M().an().j().b() && super.canUse(var1);
   }

   public String c(ICommandListener var1) {
      return "commands.banip.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length >= 1 && var2[0].length() > 1) {
         IChatBaseComponent var3 = var2.length >= 2?a(var1, var2, 1):null;
         Matcher var4 = a.matcher(var2[0]);
         if(var4.matches()) {
            this.a(var1, var2[0], var3 == null?null:var3.c());
         } else {
            EntityPlayer var5 = MinecraftServer.M().an().a(var2[0]);
            if(var5 == null) {
               throw new ExceptionPlayerNotFound("commands.banip.invalid", new Object[0]);
            }

            this.a(var1, var5.w(), var3 == null?null:var3.c());
         }

      } else {
         throw new ExceptionUsage("commands.banip.usage", new Object[0]);
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().I()):null;
   }

   protected void a(ICommandListener var1, String var2, String var3) {
      IpBanEntry var4 = new IpBanEntry(var2, (Date)null, var1.getName(), (Date)null, var3);
      MinecraftServer.M().an().j().a((JsonListEntry)var4);
      List var5 = MinecraftServer.M().an().b(var2);
      String[] var6 = new String[var5.size()];
      int var7 = 0;

      EntityPlayer var9;
      for(Iterator var8 = var5.iterator(); var8.hasNext(); var6[var7++] = var9.getName()) {
         var9 = (EntityPlayer)var8.next();
         var9.a.c("You have been IP banned.");
      }

      if(var5.isEmpty()) {
         a(var1, this, "commands.banip.success", new Object[]{var2});
      } else {
         a(var1, this, "commands.banip.success.players", new Object[]{var2, a(var6)});
      }

   }

}
