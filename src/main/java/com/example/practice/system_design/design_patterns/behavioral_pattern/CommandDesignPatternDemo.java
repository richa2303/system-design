package com.example.practice.system_design.design_patterns.behavioral_pattern;

interface FileSystemReceiver{

    void openFile();
    void closeFile();
    void writeFile();

}

class MacSystem implements  FileSystemReceiver{

    @Override
    public void openFile() {
        System.out.println("Open Mac System File ...");
    }

    @Override
    public void closeFile() {
        System.out.println("Close Mac System File ...");
    }

    @Override
    public void writeFile() {
        System.out.println("Write Mac System File ...");
    }
}
class WindowsSystem implements FileSystemReceiver{

    @Override
    public void openFile() {
        System.out.println("Open Windows System File ...");
    }

    @Override
    public void closeFile() {
        System.out.println("Close Windows System File ...");
    }

    @Override
    public void writeFile() {
        System.out.println("Write Windows System File ...");
    }
}
interface Command{

    void execute();
}

class OpenFileCommand implements Command{

    FileSystemReceiver receiver;

    OpenFileCommand(FileSystemReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.openFile();
    }
}
class CloseFileCommand implements Command{

    FileSystemReceiver receiver;

    CloseFileCommand(FileSystemReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.closeFile();
    }
}
class WriteFileCommand implements Command{

    FileSystemReceiver receiver;

    WriteFileCommand(FileSystemReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.writeFile();
    }
}
class FileInvoker{

    Command command;

    FileInvoker(Command command){
        this.command = command;
    }

    void execute(){
        this.command.execute();
    }
}
class FileSystemReceiverUtil{

    public static FileSystemReceiver getUnderlyingFileSystem() {
        String osName = System.getProperty("os.name");
        System.out.println("Underlying OS is:" + osName);
        if (osName.contains("Windows")) {
            return new WindowsSystem();
        } else {
            return new MacSystem();
        }
    }
}
public class CommandDesignPatternDemo {

    public static void main(String args[]){

        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

        Command openFileCommand = new OpenFileCommand(fs);
        FileInvoker file = new FileInvoker(openFileCommand);
        file.execute();

        Command writeFileCommand = new WriteFileCommand(fs);
        FileInvoker file1 = new FileInvoker(writeFileCommand);
        file1.execute();

        Command fileCloseCommand = new CloseFileCommand(fs);
        FileInvoker file2 = new FileInvoker(fileCloseCommand);
        file2.execute();
    }
}
