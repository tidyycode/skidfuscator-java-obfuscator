package dev.skidfuscator.obfuscator;

import lombok.SneakyThrows;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.File;

public class SkidfuscatorMain {

    @SneakyThrows
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("cli")) {
            final LineReader reader = LineReaderBuilder.builder()
                    .terminal(TerminalBuilder.terminal())
                    .appName("Skidfuscator")
                    .parser(new DefaultParser())
                    .build();


            while (true) {
                String line = null;

                try {
                    line = reader.readLine("> ");
                } catch (UserInterruptException e) {
                    // Ignore
                } catch (EndOfFileException e) {
                    return;
                }

                if (line == null)
                    continue;

                if (line.contains("obfuscate")) {
                    final String input = line.split(" ")[1];
                    final String output = line.split(" ")[2];

                    final SkidfuscatorSession session = new SkidfuscatorSession(
                            new File(input),
                            new File(output)
                    );

                    final Skidfuscator skidfuscator = new Skidfuscator(session);
                    skidfuscator.run();
                }
            }

        }
    }
}