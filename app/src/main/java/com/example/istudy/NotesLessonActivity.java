package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import org.parceler.Parcels;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesLessonActivity extends AppCompatActivity implements OnLoadCompleteListener, OnPageChangeListener, OnPageErrorListener {
    @BindView(R.id.pdfView)
    PDFView pdfView;
    ProgressDialog progressDialog;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_lesson);
        ButterKnife.bind(this);
        progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("Loading the file, Please wait ...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        String notes_url = Parcels.unwrap(getIntent().getParcelableExtra("notes"));
        url ="https://istudy4.herokuapp.com"+notes_url;

        FileLoader.with(this)
                .load("https://istudy4.herokuapp.com/media/Images/lesson_files/1/1_au0lNxV.pdf",false) //2nd parameter is optioal, pass true to force load from network
                .fromDirectory("test4", FileLoader.DIR_INTERNAL)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
                        File url = response.getBody();
                        // do something with the file
                        try {
                            pdfView.fromFile(url)
                                    .pages(0,1)
                                    .defaultPage(0)
                                    .enableSwipe(true)
                                    .enableAnnotationRendering(true)
                                    .onLoad(NotesLessonActivity.this)
                                    .onPageChange(NotesLessonActivity.this)
                                    .scrollHandle(new DefaultScrollHandle(NotesLessonActivity.this))
                                    .enableDoubletap(true)
                                    .onPageError(NotesLessonActivity.this)
                                    .swipeHorizontal(true)
                                    .spacing(0)
                                    .fitEachPage(false)
                                    .nightMode(false)
                                    .pageFitPolicy(FitPolicy.WIDTH)
                                    .autoSpacing(false)
                                    .load();

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(NotesLessonActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
    @Override
    public void loadComplete(int nbPages) {
        progressDialog.dismiss();

    }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public void onPageError(int page, Throwable t) {

    }
}