package glir2115MV.Repositories;

import glir2115MV.Models.Elev;
import glir2115MV.Models.Medie;
import glir2115MV.Models.Nota;
import glir2115MV.utils.ClasaException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ClasaRepositoryTest {

    private List<Medie> medii;
    private List<Nota> note;
    private List<Elev> elevi;
    private HashMap<Elev, HashMap<String, List<Double>>> clasa;
    private ClasaRepository repoClasa;
    private NoteRepository repoNote;
    private EleviRepository repoElevi;

    @Before
    public void setUp() throws Exception {
        repoElevi = new EleviRepository();
        repoNote = new NoteRepository();
        repoClasa = new ClasaRepository();

        System.out.println("--  Setting up for tests! -- \n");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\n-- Tearing all down! --\n");
    }

    @Test
    public void calculeazaMedii() throws ClasaException {
        repoElevi.readElevi("/Users/denisah/Documents/University Sem2/VVSS/NoteElevi/src/main/java/glir2115MV/note");
        elevi = repoElevi.getElevi();
        repoNote.readNote("/Users/denisah/Documents/University Sem2/VVSS/NoteElevi/src/main/java/glir2115MV/note");
        note = repoNote.getNote();

        repoClasa.creazaClasa(elevi,note);
        clasa = repoClasa.getClasa();

        System.out.println("Test calculeazaMedii - with succes!\n");
        medii = repoClasa.calculeazaMedii();
        for(Medie medie : medii) {
            System.out.println(medie.getElev()+ " " + medie.getMedie());
        }
        assertEquals(10, medii.size());
        System.out.println("Test passed!\n");
    }

    @Test
    public void calculeazaMediiFail() throws ClasaException {

        repoElevi.readElevi("/Users/denisah/Documents/University Sem2/VVSS/NoteElevi/src/main/java/glir2115MV/noteEmpty");
        elevi = repoElevi.getElevi();

        repoNote.readNote("/Users/denisah/Documents/University Sem2/VVSS/NoteElevi/src/main/java/glir2115MV/noteEmpty");
        note = repoNote.getNote();

        repoClasa.creazaClasa(elevi,note);
        clasa = repoClasa.getClasa();

        System.out.println("Test calculeazaMedii - fail!\n");
        try {
            medii = repoClasa.calculeazaMedii();
        } catch (ClasaException e) {
            assertEquals(0, medii.size());
            e.printStackTrace();
            System.out.println("-- Test passed! Exception found! --\n");
        }
    }
}