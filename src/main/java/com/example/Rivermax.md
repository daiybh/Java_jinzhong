1. there have two ini files   in "C:\ProgramData\SimplyLive.TV\ViBox\BackEnd\"
   - Rivermax.ini
   - HardWare.ini
  
2. change the card_type = 10 in the hardware.ini
   
   [GENERAL]
      Card_Type = 10
   

3. config the "Rivermax.ini"
   
   - Config the source for camera

      [Rivermax]
      # Cam#id#_video="localNICIP:broadCastIP:broadCastPort"
      # Cam#id#_audio="localNICIP:broadCastIP:broadCastPort"
      
         Cam1_video = "10.0.30.170:225.1.1.1:9998"
         Cam1_audio = "10.0.30.170:225.1.1.2:9998"
      
      Cam1_Video  is for  cam1's Video on the webconfig.
   
   - Config the source format
      [Rivermax]
        sourceFormat=0    ;  0 : uyvy_8bits
		                    ;  1 : uyvy_10bits_bytePacking

4. config on webconfig 
   it same as  SDI config . 
