package uml;
import org.jline.reader.Completer;
import org.jline.reader.impl.completer.StringsCompleter;

import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.AggregateCompleter;

import org.jline.reader.impl.completer.NullCompleter;


public class TabCompletion {

    private AggregateCompleter completer = null;

    public TabCompletion(){
        this.completer = new AggregateCompleter(ADCompleter, renameCompleter, changeCompleter, changeAllCompleter, deleteAllCompleter, listCompleter, singleCompleter);
    }
    
    ArgumentCompleter ADCompleter = new ArgumentCompleter(
    new StringsCompleter("add", "delete"),
    new StringsCompleter("class", "field", "method", "parameter", "relation"),
    new NullCompleter());

    ArgumentCompleter renameCompleter = new ArgumentCompleter(
    new StringsCompleter("rename"),
    new StringsCompleter("class", "field", "method"),
    new NullCompleter());

    ArgumentCompleter changeCompleter = new ArgumentCompleter(
    new StringsCompleter("change"),
    new StringsCompleter("parameter", "relationship type"),
    new NullCompleter());

    ArgumentCompleter changeAllCompleter = new ArgumentCompleter(
    new StringsCompleter("change all"),
    new StringsCompleter("parameter"),
    new NullCompleter());

    ArgumentCompleter deleteAllCompleter = new ArgumentCompleter(
    new StringsCompleter("delete all"),
    new StringsCompleter("parameters", "methods"),
    new NullCompleter());

    ArgumentCompleter listCompleter = new ArgumentCompleter(
    new StringsCompleter("list"),
    new StringsCompleter("contents", "classes", "relationships"),
    new NullCompleter());

    ArgumentCompleter singleCompleter = new ArgumentCompleter(
    new StringsCompleter("undo", "redo", "screenshot", "help", "save", "load", "exit","gui", "set position"),
    new NullCompleter());

}
