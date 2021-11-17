package uml;
import org.jline.reader.impl.completer.StringsCompleter;

import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.AggregateCompleter;

import org.jline.reader.impl.completer.NullCompleter;


public class TabCompletion {

    public static AggregateCompleter compose(){
        AggregateCompleter c = new AggregateCompleter(ADCompleter, renameCompleter, changeCompleter, changeAllCompleter, deleteAllCompleter, listCompleter, singleCompleter);
        return c;
    } 

    public static ArgumentCompleter ADCompleter = new ArgumentCompleter(
    new StringsCompleter("add", "delete"),
    new StringsCompleter("class", "field", "method", "parameter", "relation"),
    new NullCompleter());

    public static ArgumentCompleter renameCompleter = new ArgumentCompleter(
    new StringsCompleter("rename"),
    new StringsCompleter("class", "field", "method"),
    new NullCompleter());

    public static ArgumentCompleter changeCompleter = new ArgumentCompleter(
    new StringsCompleter("change"),
    new StringsCompleter("parameter", "relationship type"),
    new NullCompleter());

    public static ArgumentCompleter changeAllCompleter = new ArgumentCompleter(
    new StringsCompleter("change"),
    new StringsCompleter("all"),
    new StringsCompleter("parameters"),
    new NullCompleter());

    public static ArgumentCompleter deleteAllCompleter = new ArgumentCompleter(
    new StringsCompleter("delete"),
    new StringsCompleter("all"),
    new StringsCompleter("parameters", "methods"),
    new NullCompleter());

    public static ArgumentCompleter listCompleter = new ArgumentCompleter(
    new StringsCompleter("list"),
    new StringsCompleter("contents", "classes", "relationships"),
    new NullCompleter());

    public static ArgumentCompleter singleCompleter = new ArgumentCompleter(
    new StringsCompleter("undo", "redo", "screenshot", "help", "save", "load", "exit","gui", "set position"),
    new NullCompleter());

}
