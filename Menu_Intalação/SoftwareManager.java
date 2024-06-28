import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SoftwareManager {
    private List<Software> softwareList;

    public SoftwareManager() {
        softwareList = new ArrayList<>();
        // Adicione os softwares disponíveis aqui

        addSoftware(new Software("7-Zip", "\"J:\\1-9\\7Zip\\setup.exe\" /S"));

        addSoftware(new Software("Audacity", "\"J:\\A\\Audacity\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Adobe Acrobat Reader DC", "\"J:\\A\\Adobe Acrobat Reader DC\\setup.exe\" /sAll /rs /msi EULA_ACCEPT=YES DISABLEDESKTOPSHORTCUT=1"));
        addSoftware(new Software("Anaconda", "\"J:\\A\\Anaconda\\setup.exe\" /InstallationType=Allusers /RegisterPython=0 /S"));
        addSoftware(new Software("Android Studio", "\"J:\\A\\Android Studio\\setup.exe\" /InstallationType=Allusers /RegisterPython=0 /S"));
        addSoftware(new Software("ACCA Solarius-PV","\"J:\\A\\ACCA Solarius-PV\\setup.exe\" -SILENTMODE"));
        addSoftware(new Software("ACCA Termus-Bridge","\"J:\\A\\ACCA Termus-Bridge\\setup.exe\" -SILENTMODE"));
        addSoftware(new Software("ACCA Termus-Plus","\"J:\\A\\ACCA Termus-Plus\\setup.exe\" -SILENTMODE"));
        addSoftware(new Software("Apps FAMAT","J:\\A\\Apps FAMAT\\AppsFAMAT.exe"));
        addSoftware(new Software("Arduino", "msiexec -i \"J:\\A\\Arduino\\setup.msi\" ALLUSERS=1 /quiet"));
        addSoftware(new Software("Astah","J:\\A\\Astah Professional\\Astah.exe"));

        addSoftware(new Software("Autodesk 3dsMax 2024","\"J:\\A\\Autodesk 3dsMax 2024\\setup.exe\" -q"));
        addSoftware(new Software("Autodesk AutoCad 2024","\"J:\\A\\Autodesk AutoCAD 2024\\setup.exe\" -q"));
        addSoftware(new Software("Autodesk Inventor 2024","\"J:\\A\\Autodesk Inventor 2024\\setup.exe\" -q"));
        addSoftware(new Software("Autodesk Navisworks 2024","\"J:\\A\\Autodesk Navisworks 2024\\setup.exe\" -q"));
        addSoftware(new Software("Autodesk Revit 2024","\"J:\\A\\Autodesk Revit 2024\\setup.exe\" -q"));

        addSoftware(new Software("Autodesk AutoCAD 2023","\"J:\\A\\Autodesk AutoCAD 2023\\setup.exe\" -q"));
        addSoftware(new Software("Autodesk 3dsMax 2023","\"J:\\A\\Autodesk 3dsMax 2023\\setup.exe\" -q"));
        addSoftware(new Software("Autodesk Inventor 2023","\"J:\\A\\Autodesk Inventor 2023\\setup.exe\" -q"));
        addSoftware(new Software("Autodesk NavisWork 2023","\"J:\\A\\Autodesk Navisworks 2023\\setup.exe\" -q"));
        addSoftware(new Software("Autodesk Revit 2023","\"J:\\A\\Autodesk Revit 2023\\setup.exe\" -q"));

        addSoftware(new Software("Autodesk Civil 3D 2024","\"J:\\A\\Autodesk Civil 3D\\setup.exe\" -q"));
        addSoftware(new Software("Autodesk Eagle", "\"J:\\A\\Autodesk Eagle\\setup.exe\" /SP- /SUPPRESSMSGBOXES /VERYSILENT"));
        addSoftware(new Software("Autodesk Fusion","\"J:\\A\\Autodesk Fusion\\setup.exe\" --quiet"));

        addSoftware(new Software("Bimsync", "J:\\B\\Bimsync\\Bimsync.exe"));
        addSoftware(new Software("Bizagi Modeler", "msiexec -i \"J:\\B\\Bizagi Modeler\\setup.msi\" /quiet"));
        addSoftware(new Software("Blender", "msiexec -i \"J:\\B\\Blender\\setup.msi\" /quiet"));
        addSoftware(new Software("Bluej", "msiexec -i \"J:\\B\\BlueJ\\setup.msi\" /quiet"));
        addSoftware(new Software("Brmodelo", "J:\\B\\BrModelo\\BrModelo.exe"));

        addSoftware(new Software("Cheddar", "J:\\C\\Cheddar\\Cheddar.exe"));
        addSoftware(new Software("Chitobox", "\"J:\\C\\Chitubox\\setup.exe\" /S"));
        addSoftware(new Software("Cisco Jabber", "msiexec -i \"J:\\C\\Cisco Jabber\\setup.msi\" /quiet"));
        addSoftware(new Software("CodeBlocks", "\"J:\\C\\CodeBlocks\\setup.exe\" /S"));
        addSoftware(new Software("Codesys", "\"J:\\C\\Codesys\\setup.exe\" /SP- /SUPPRESSMSGBOXES /VERYSILENT"));
        addSoftware(new Software("Coolpack", "J:\\C\\Coolpack\\Coolpack.exe"));

        addSoftware(new Software("DB Browser for SQLite", "J:\\D\\DB Browser for SQLite\\DB Browser for SQLite.exe"));
        addSoftware(new Software("Decision Tools", "J:\\D\\Decision Tools\\Decision Tools.exe"));
        addSoftware(new Software("DELL Command Update", "\"J:\\D\\DELL Command Update\\setup.exe\" /S /v/qn"));
        addSoftware(new Software("Democracy 3","\"J:\\D\\Democracy 3\\setup.exe\" /SP- /SUPPRESSMSGBOXES /VERYSILENT"));
        addSoftware(new Software("DIALux Evo", "\"J:\\D\\DIALux Evo\\setup.exe\" /s"));
        addSoftware(new Software("Dicionário HOUAISS","\"J:\\D\\Dicionário HOUAISS\\setup.exe\" /S /v/qn"));
        addSoftware(new Software("Digifort", "\"J:\\D\\DIGIFORT\\setup.exe\" /s"));
        addSoftware(new Software("Digilent Adept", "\"J:\\D\\Diligent Adept\\setup.exe\" /S"));
        addSoftware(new Software("DigitalWorks", "J:\\D\\DigitalWorks\\DigitalWorks.exe"));
        addSoftware(new Software("Docker Desktop", "J:\\D\\Docker Desktop\\setup.exe"));
        addSoftware(new Software("Dosvox", "\"J:\\D\\Dosvox\\setup.exe\" /VERYSILENT"));

        addSoftware(new Software("Eclipse","J:\\E\\Eclipse\\Eclipse.exe"));
        addSoftware(new Software("Emso","\"J:\\E\\Emso\\setup.exe\" /VERYSILENT"));
        addSoftware(new Software("EndNote Plugins","msiexec /i \"J:\\E\\EndNote Plugins\\setup.msi\" /passive"));
        addSoftware(new Software("Energy Plus","J:\\E\\Energy Plus\\Energy Plus.exe"));
        addSoftware(new Software("Enscape","msiexec /i \"J:\\E\\Enscape\\setup.msi\" /passive"));
        addSoftware(new Software("Epi Info","msiexec /i \"J:\\E\\Epi Info\\setup.msi\" /passive"));
        addSoftware(new Software("Etap","\"J:\\E\\Etap\\setup.exe\" /quiet"));
        addSoftware(new Software("Etap Config","J:\\E\\Etap\\Etap.exe"));
        addSoftware(new Software("Eletrobras - Anafas","\"J:\\E\\Eletrobras - Anafas\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - Anarede","\"J:\\E\\Eletrobras - Anarede\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - Anatem","\"J:\\E\\Eletrobras - Anatem\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - CDUEdit","\"J:\\E\\Eletrobras - CDUEdit\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - EditCepel","\"J:\\E\\Eletrobras - EditCepel\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - Flupot","\"J:\\E\\Eletrobras - Flupot\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - FormCepel","\"J:\\E\\Eletrobras - FormCepel\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - Harmzs","\"J:\\E\\Eletrobras - Harmzs\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - NH2","\"J:\\E\\Eletrobras - NH2\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - PacDyn","\"J:\\E\\Eletrobras - PacDyn\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - PlotCepel","\"J:\\E\\Eletrobras - PlotCepel\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Eletrobras - Config","J:\\E\\Eletrobras - Config\\Eletrobras.exe"));

        addSoftware(new Software("Femm","\"J:\\F\\Femm\\setup.exe\" /SP- /SUPPRESSMSGBOXES /VERYSILENT"));
        addSoftware(new Software("FFmpeg","\"J:\\F\\FFmpeg\\setup.exe\" /VERYSILENT /SUPPRESSMSGBOXES /NORESTART"));
        addSoftware(new Software("FontFort","\"J:\\F\\FontForge\\setup.exe\" /VERYSILENT"));
        addSoftware(new Software("FontLab","msiexec /i \"J:\\F\\FontLab\\setup.msi\" /passive"));
        addSoftware(new Software("FontLab VI","msiexec /i \"J:\\F\\FontLab VI\\setup.msi\" /passive"));
        addSoftware(new Software("FreeCAD","\"J:\\F\\FreeCAD\\setup.exe\" /S"));
        addSoftware(new Software("FTool","J:\\F\\FTool\\Ftool.exe"));
        addSoftware(new Software("Fortran","\"J:\\F\\Fortran\\setup.exe\" /sp- /supressmsgboxes /verysilent"));

        addSoftware(new Software("Gams","\"J:\\G\\Gams\\setup.exe\" /SP- /VERYSILENT"));
        addSoftware(new Software("Gempack","J:\\G\\Gempack\\Gempack.exe"));
        addSoftware(new Software("Gempack Config","J:\\G\\Gempack\\GempackConfig.exe"));
        addSoftware(new Software("Genopro","\"J:\\G\\Genopro\\setup.exe\" /PathDefault C:\\GenoPro /U"));
        addSoftware(new Software("GeoDa","\"J:\\G\\GeoDa\\setup.exe\" /SP- /VERYSILENT /SUPPRESSMSGBOXES"));
        addSoftware(new Software("Geogebra","msiexec /i \"J:\\G\\Geogebra\\setup.msi\" /passive"));
        addSoftware(new Software("Gimp","\"J:\\G\\Gimp\\setup.exe\" /VERYSILENT /NORESTART /ALLUSERS"));
        addSoftware(new Software("Git","\"J:\\G\\Git\\setup.exe\" /VERYSILENT /NORESTART /COMPONENTS=ext,ext\\shellhere,ext\\guihere,gitlfs,assoc,assoc_sh,autoupdate"));
        addSoftware(new Software("GNU Octave","\"J:\\G\\GNU Octave\\setup.exe\" /AllUsers /S"));
        addSoftware(new Software("Gnuplot","\"J:\\G\\Gnuplot\\setup.exe\" /SP- /VERYSILENT /NORESTART"));
        addSoftware(new Software("Go","msiexec /i \"J:\\G\\Go\\setup.msi\" ALLUSERS=1 /passive"));
        addSoftware(new Software("Godot","J:\\G\\Godot\\Godot.exe"));
        addSoftware(new Software("Google Chrome","msiexec /q /I \"J:\\G\\Google Chrome\\setup.msi\""));
        addSoftware(new Software("Google Chrome Config","J:\\G\\Google Chrome\\Chrome\\Chrome.exe"));
        addSoftware(new Software("Graphmatica","msiexec /i \"J:\\G\\Graphmatica\\setup.msi\" /passive"));
        addSoftware(new Software("GPower","msiexec /i \"J:\\G\\GPower\\setup.msi\" /passive"));

        addSoftware(new Software("ImageJ","J:\\I\\ImageJ\\ImageJ.exe"));
        addSoftware(new Software("Inkscape","msiexec /i \"J:\\I\\Inkscape\\setup.msi\" /passive"));
        addSoftware(new Software("IntelliJ","\"J:\\I\\IntelliJ\\setup.exe\" /S"));
        addSoftware(new Software("IronPython","msiexec /i \"J:\\I\\IronPython\\setup.msi\" /passive"));

        addSoftware(new Software("Jamovi","\"J:\\J\\Jamovi\\setup.exe\" /S"));
        addSoftware(new Software("Jasp","msiexec /i \"J:\\J\\Jasp\\setup.msi\" ALLUSERS=1 /passive"));
        addSoftware(new Software("Java Development Kit","\"J:\\J\\Java Development Kit\\setup.exe\" /s"));
        addSoftware(new Software("Java Runtime Environment","\"J:\\J\\Java Runtime Environment\\setup.exe\" /s"));
        addSoftware(new Software("Java Scene Builder","msiexec /i \"J:\\J\\Java Scene Builder\\setup.msi\" /passive"));
        addSoftware(new Software("JavaFX","J:\\J\\JavaFX\\JavaFX.exe"));
        addSoftware(new Software("JDK","msiexec /i \"J:\\J\\JDK\\setup.msi\" /passive"));

        addSoftware(new Software("KiCAD","\"J:\\K\\KiCAD\\setup.exe\" /AllUsers /S"));
        addSoftware(new Software("K-Lite Codec","\"J:\\K\\K-Lite Codec\\setup.exe\" /SP- /VERYSILENT /SUPPRESSMSGBOXES /NORESTART"));

        addSoftware(new Software("Laboratorio de Reatores","J:\\L\\Laboratorio de Reatores\\Laboratorio de Reatores.exe"));
        addSoftware(new Software("Lame","\"J:\\L\\Lame\\setup.exe\" /VERYSILENT /SUPPRESSMSGBOXES /NORESTART"));
        addSoftware(new Software("LAPS","msiexec /i \"J:\\L\\LAPS\\LAPS.x64.msi\" /passive"));
        addSoftware(new Software("Lenovo System Update","\"J:\\L\\Lenovo System Update\\setup.exe\" /SP- /VERYSILENT /NORESTART"));
        addSoftware(new Software("LTSpice","msiexec /i \"J:\\L\\LTSpice\\setup.msi\" /passive"));
        addSoftware(new Software("Lego Mindstorms NXT","\"J:\\L\\Lego Mindstorms NXT\\setup.exe\" /qb /acceptlicenses yes /r:n"));

        addSoftware(new Software("Make Money","\"J:\\M\\Make Money\\deploy\\setup.exe\" /quiet"));
        addSoftware(new Software("Matlab","J:\\M\\MATLAB\\GTIT\\R2012B\\Matlab.exe"));
        addSoftware(new Software("Mars","J:\\M\\Mars\\Mars.exe"));
        addSoftware(new Software("Maxima","\"J:\\M\\Maxima\\setup.exe\" /S /D=C:\\Program Files\\Maxima"));
        addSoftware(new Software("Mega","\"J:\\M\\Mega\\setup.exe\" /SILENT /VERYSILENT"));
        addSoftware(new Software("Mendeley Desktop","\"J:\\M\\Mendeley Desktop\\setup.exe\" /S"));
        addSoftware(new Software("MeshLab","\"J:\\M\\MeshLab\\setup.exe\" /S"));
        //addSoftware(new Software("Microsoft Office 365 User (Word, Excel, PowerPoint, Outlook)",""));
        //addSoftware(new Software("Microsoft Office 365 User (Word, Excel, PowerPoint, Outlook, Access)",""));
        //addSoftware(new Software("Microsoft Office 365 User (Word, Excel, PowerPoint, Outlook, Publisher)",""));
        addSoftware(new Software("Microsoft Office 2019 (Word, Excel, PowerPoint, Outlook)","J:\\M\\Microsoft Office\\2024\\Office 2019\\x86\\Office.exe"));
        addSoftware(new Software("Microsoft Office 365 User (Word, Excel, PowerPoint, Outlook)","J:\\M\\Microsoft Office\\2024\\Office Device\\Microsoft Office 365 (Word,Excel,PowerPoint,Outlook)\\Office.exe"));
        //addSoftware(new Software("Microsoft Office 365 Device (Word, Excel, PowerPoint, Outlook)",""));
        //addSoftware(new Software("Microsoft Office 365 Device (Word, Excel, PowerPoint, Outlook, Access)",""));
        //addSoftware(new Software("Microsoft Office 365 Device (Word, Excel, PowerPoint, Outlook, Publisher)",""));
        addSoftware(new Software("Microsoft Power BI","\"J:\\M\\Microsoft Office\\2024\\Microsoft Power BI\\setup.exe\" -quiet -norestart ACCEPT_EULA=1 DISABLE_UPDATE_NOTIFICATION=1"));
        addSoftware(new Software("Microsoft Project","J:\\M\\Microsoft Office\\2024\\Microsoft Project\\Project.exe"));
        addSoftware(new Software("Microsoft Project Config","cmd /c mklink \"C:\\Users\\Public\\Desktop\\Project\" \"C:\\Program Files\\Microsoft Office\\root\\Office16\\WINPROJ.EXE\""));
        addSoftware(new Software("Microsoft Visio","J:\\M\\Microsoft Office\\2024\\Microsoft Visio\\Visio.exe"));
        addSoftware(new Software("Microsoft Visio Config","cmd /c mklink \"C:\\Users\\Public\\Desktop\\Visio\" \"C:\\Program Files\\Microsoft Office\\root\\Office16\\VISIO.EXE\""));
        addSoftware(new Software("Minitab 17","\"J:\\M\\Minitab 17\\setup.exe\" /exenoui /qn ACCEPT_EULA=1 LICENSE_SERVER=10.40.48.92 LICENSE_SERVER_PORT=27011 DISABLE_UPDATES=1"));
        addSoftware(new Software("Movie Maker","\"J:\\M\\Movie Maker\\setup.exe\" /AppSelect:MovieMaker /NOToolbarCEIP /NOhomepage /Nolaunch /NOMU /nosearch /q"));
        addSoftware(new Software("Mozilla Firefox","msiexec /i \"J:\\M\\Mozilla Firefox\\setup.msi\" /passive"));

        addSoftware(new Software("NodeJS", "msiexec /i \"J:\\N\\NodeJS\\setup.msi\" /passive"));
        addSoftware(new Software("Notepad++", "\"J:\\N\\Notepad++\\setup.exe\" /S"));

        addSoftware(new Software("OpenDSS", "\"J:\\O\\OpenDSS\\setup.exe\" /SP- /SUPPRESSMSGBOXES /VERYSILENT /NORESTART"));
        addSoftware(new Software("OpenLCA", "\"J:\\O\\OpenLCA\\setup.exe\" /S /D=C:\\Program Files\\openLCA"));
        addSoftware(new Software("Oracle VM Virtual Box", "\"J:\\O\\Oracle VM Virtual Box\\setup.exe\" --silent --ignore-reboot"));
        addSoftware(new Software("Orange Data Mining", "\"J:\\O\\Orange Data Mining\\setup.exe\" /S /AllUsers /D=\"C:\\Program Files\\Orange\" /AddToPath=0 /RegisterPython=0"));

        addSoftware(new Software("Plano de Negocio", "msiexec /i \"J:\\P\\Plano de Negócio\\setup.msi\" /passive"));
        addSoftware(new Software("Podman", "J:\\P\\Podman\\Podman.exe"));
        addSoftware(new Software("Power World","msiexec /i \"J:\\P\\Power World\\setup.msi\" /passive"));
        addSoftware(new Software("Powersim","\"J:\\P\\Powersim\\setup.exe\" /VERYSILENT"));
        addSoftware(new Software("Praat","J:\\P\\Praat\\Praat.exe"));
        addSoftware(new Software("Processing","J:\\P\\Processing\\processing.exe"));
        addSoftware(new Software("Promodel","\"J:\\P\\Promodel\\setup.exe\" /exenoui /qn"));
        addSoftware(new Software("Proteus 7", "J:\\P\\Proteus 7\\Proteus 7.exe"));
        addSoftware(new Software("Putty","msiexec /i \"J:\\P\\Putty\\setup.msi\" /passive"));
        addSoftware(new Software("PTC Creo 7", "\"J:\\P\\PTC CREO\\Creo 7\\setup.exe\" -xml \"J:\\C\\Creo\\creobase.p.xml\" -xml \"J:\\C\\Creo\\dma.p.xml\" -xml \"J:\\C\\Creo\\layout.p.xml\" -xml \"J:\\C\\Creo\\pma.p.xml\" -xml \"J:\\C\\Creo\\sim.p.xml\""));
        addSoftware(new Software("PTC Creo 7 Config","J:\\P\\PTC CREO\\Creo 7\\PTC_Creo.exe"));
        addSoftware(new Software("Python","\"J:\\P\\Python\\setup.exe\" /quiet InstallAllUsers=1 PrependPath=1 AssociateFiles=1"));
        //addSoftware(new Software("PROII", "\"J:\\P\\PROII\\PROII\\Setup.exe\" /silent"));
        //addSoftware(new Software("PROII Config","Powershell.exe -File \"J:\\P\\PROII\\PROII\\Config_PROII.ps1\""));

        addSoftware(new Software("QGis","msiexec /i \"J:\\Q\\QGis\\setup.msi\" /passive"));

        addSoftware(new Software("R for Windows","\"J:\\R\\R for Windows\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("R Studio","\"J:\\R\\R Studio\\setup.exe\" /S"));
        addSoftware(new Software("Rhinoceros","msiexec /i \"J:\\R\\Rhinoceros\\setup.msi\" /passive"));
        addSoftware(new Software("Reatores Quimicos","cmd /c \"J:\\R\\Reatores Quimicos\\Retores quimicos.cmd\""));

        addSoftware(new Software("Saepro","msiexec /i \"J:\\S\\Saepro\\setup.msi\" /passive"));
        addSoftware(new Software("Safe Exam Browser","\"J:\\S\\Safe Exam Browser\\setup.exe\" /install /quiet /norestart"));
        addSoftware(new Software("Scilab","\"J:\\S\\Scilab\\setup.exe\" /SP- /SUPPRESSMSGBOXES /VERYSILENT"));
        addSoftware(new Software("Scratch","\"J:\\S\\Scratch\\setup.exe\" /Allusers /S"));
        addSoftware(new Software("Sketchup","\"J:\\S\\Sketchup\\setup.exe\" /silent"));
        addSoftware(new Software("Sketchup Config","cmd /c \"J:\\S\\Sketchup\\Config_Sketchup.cmd\""));
        addSoftware(new Software("SolidWorks","\"J:\\S\\SolidWorks\\startswinstall.exe\" /now"));
        addSoftware(new Software("SolidWorks Config","cmd /c \"J:\\S\\SolidWorks\\Config_SolidWorks.cmd\""));
        addSoftware(new Software("SPSS Statistics 17","msiexec /i \"J:\\S\\SPSS Statistics 17\\setup.msi\" /qb SPSSLICENSE=\"Network\" LSHOST=\"POA01LIC03\""));
        addSoftware(new Software("Stata12","cmd /c\"J:\\S\\Stata12\\Install_Stata12.cmd\""));
        addSoftware(new Software("Stata18","\"J:\\S\\Stata18\\setup.exe\" /s /v\"/qn ADDLOCAL=core,StataBE64 USEPERSONALDIR=0\""));
        addSoftware(new Software("Stata18 Config","cmd /c \"J:\\S\\Stata18\\Config_Stata18.cmd\""));
        addSoftware(new Software("SubtitleEdit","\"J:\\S\\SubtitleEdit\\setup.exe\" /VERYSILENT /NORESTART"));

        addSoftware(new Software("TexStudio","cmd /c\"J:\\T\\TexStudio\\Install.cmd\""));
        addSoftware(new Software("TexWorks","\"J:\\T\\TexWorks\\setup.exe\" /SP- /VERYSILENT /NORESTART"));
        addSoftware(new Software("Tina TI","cmd /c \"J:\\T\\Tina TI\\Install.bat\""));
        addSoftware(new Software("TinnR","\"J:\\T\\TinnR\\setup.exe\" /SP- /VERYSILENT /NORESTART"));

        addSoftware(new Software("Unity","\"J:\\U\\Unity\\setup.exe\" /allusers /S"));
        addSoftware(new Software("UltiMaker Cura","\"J:\\U\\UltiMaker Cura\\setup.exe\" /S /VERYSILENT /SUPPRESSMSGBOXES /NORESTART"));

        addSoftware(new Software("Vagrant","msiexec /i \"J:\\V\\Vagrant\\setup.msi\" /passive /norestart"));
        addSoftware(new Software("VCN","cmd /c \"J:\\V\\VCN\\Install.cmd\""));
        addSoftware(new Software("Visual Studio Code","\"J:\\V\\Visual Studio Code\\setup.exe\" /VERYSILENT /NORESTART /MERGETASKS=!runcode,desktopicon,addcontextmenufiles,addcontextmenufolders,associatewithfiles"));
        addSoftware(new Software("VLC Media Player","\"J:\\V\\VLC Media Player\\setup.exe\" /S"));

        addSoftware(new Software("Weka", "\"J:\\W\\Weka\\setup.exe\" /S"));
        addSoftware(new Software("Who Anthro", "\"J:\\W\\Who Anthro\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Who Anthro Plus", "\"J:\\W\\Who Anthro Plus\\setup.exe\" /VERYSILENT /NORESTART"));
        addSoftware(new Software("Winamp", "\"J:\\W\\Winamp\\setup.exe\" /S"));
        addSoftware(new Software("Windows Subsystem for Linux", "msiexec /i \"J:\\W\\Windows Subsystem for Linux\\setup.msi\" /passive"));

        addSoftware(new Software("Zoom","msiexec /i \"J:\\Z\\Zoom\\setup.msi\" /passive"));
        addSoftware(new Software("Zotero","\"J:\\Z\\Zotero\\setup.exe\" /S"));
    }

    public void addSoftware(Software software) {
        softwareList.add(software);
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void installSoftware(String softwareName, JLabel statusLabel) {
        for (Software software : softwareList) {
            if (software.getName().equals(softwareName)) {
                informUserInstallationInProgress(statusLabel);
                InstallTask installTask = new InstallTask(software, statusLabel);
                installTask.execute(); // Inicia a tarefa em segundo plano
                return;
            }
        }
        System.out.println("Software não encontrado: " + softwareName);
    }

    public void informUserToSelectInstallation(JLabel statusLabel) {
        statusLabel.setText("Por favor, selecione uma instalação.");
    }

    public void informUserInstallationInProgress(JLabel statusLabel) {
        statusLabel.setText("Aguardando instalação...");
    }

    public void informUserInstallationSuccess(JLabel statusLabel) {
        statusLabel.setText("Instalação concluída com sucesso!");
    }

    public void informUserInstallationCancelled(JLabel statusLabel) {
        statusLabel.setText("Instalação cancelada.");
    }

    // Classe InstallTask para realizar a instalação em segundo plano
    private class InstallTask extends SwingWorker<Void, Integer> {
        private Software software;
        private JLabel statusLabel;

        public InstallTask(Software software, JLabel statusLabel) {
            this.software = software;
            this.statusLabel = statusLabel;
        }

        @Override
        protected Void doInBackground() throws Exception {
            try {
                // Execute o comando de instalação do software
                @SuppressWarnings("deprecation")
                Process process = Runtime.getRuntime().exec(software.getInstallCommand());
                process.waitFor(); // Espere até que a instalação seja concluída
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                // Em caso de erro, informar o usuário que a instalação foi cancelada
                informUserInstallationCancelled(statusLabel);
                cancel(true); // Cancelar a tarefa
            }
            return null;
        }

        @Override
        protected void done() {
            if (!isCancelled()) {
                informUserInstallationSuccess(statusLabel);
            }
        }
    }
}