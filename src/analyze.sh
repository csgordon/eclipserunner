#!/bin/bash
export PATH=~/research/guitypes/checker/binary:$PATH

CHECKER=/homes/gws/csgordon/research/guitypes/checker/dist/lib/guitypes-`date "+%Y%m%d"`.jar

CFJARS="/homes/gws/csgordon/research/guitypes/checker/binary/jsr308-all.jar"

JARS="/homes/gws/csgordon/research/experiments/EclipseRunner/lib/mockito-all-1.8.2.jar:/homes/gws/csgordon/research/experiments/EclipseRunner/lib/junit-4.8.1.jar"

ECLIPSEJARS="/usr/lib/eclipse/plugins/org.eclipse.ui.navigator_3.5.100.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.ui.ide_3.7.0.dist.jar:/usr/lib/eclipse/dropins/jdt/plugins/org.eclipse.jdt.ui_3.7.0.dist.jar:/usr/lib/eclipse/dropins/jdt/plugins/org.eclipse.jdt.core_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.ui.navigator.resources_3.4.300.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.debug.core_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.debug.ui_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.core.resources_3.7.100.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.swt.gtk.linux.x86_64_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.ui_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.swt_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.jface_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.core.commands_3.6.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.ui.workbench_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.core.runtime_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.osgi_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.equinox.common_3.6.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.core.jobs_3.5.100.dist.jar:/usr/lib/ecliplse/plugins/org.eclipse.core.runtime.compatibility.registry_3.5.0.dist/runtime_registry_compatibility.jar:/usr/lib/eclipse/plugins/org.eclipse.equinox.registry_3.5.100.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.equinox.preferences_3.4.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.core.contenttype_3.4.100.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.equinox.app_1.3.100.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.ui.forms_3.5.100.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.ui.workbench.texteditor_3.7.0.dist.jar:/usr/lib/eclipse/plugins/org.eclipse.core.net_1.2.100.dist.jar"



DEBUG= #"-AprintErrorStack -Afilenames -Ashowchecks" #-Alint=debugSpew"
ERRS=999

#COMMAND="javac -J-Xbootclasspath/p:/homes/gws/csgordon/research/guitypes/checker/binary/jsr308-all.jar -J-Xms48m -J-cp -J$CFJARS -Xmaxerrs 999 -cp $CHECKER:$CFJARS:$JARS -processor guitypes.checkers.GUIEffectsChecker $DEBUG"
#COMMAND="javac -J-Xbootclasspath/p:/homes/gws/csgordon/research/guitypes/checker/binary/jsr308-all.jar -Xmaxerrs 999 -cp $CHECKER:$JARS -processor guitypes.checkers.GUIEffectsChecker $DEBUG"
#COMMAND="javac -Xmaxerrs 999 -cp $CHECKER:$JARS -processor guitypes.checkers.GUIEffectsChecker $DEBUG"
COMMAND="javac -J-Xbootclasspath/p:$CFJARS -Xmaxerrs $ERRS -cp $CHECKER:$JARS:$ECLIPSEJARS -processor guitypes.checkers.GUIEffectsChecker $DEBUG"

echo $COMMAND

JAVAFILES=`find . -name "*.java"`
echo $JAVAFILES

if [ -e $CHECKER ];
then
    find . -name '*.java' | xargs $COMMAND;
else
    pushd ~/research/guitypes/checker && ant dist && popd && find . -name '*.java' | xargs $COMMAND;
fi


#