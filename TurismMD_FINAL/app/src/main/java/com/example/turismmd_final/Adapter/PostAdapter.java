package com.example.turismmd_final.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.turismmd_final.Model.Point;
import com.example.turismmd_final.PointActivityDetails;
import com.example.turismmd_final.R;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PointViewHolder> {

    private Context context;
    private ArrayList<Point> pointList;


  //  public String image ="/9j/4AAQSkZJRgABAQAAAQABAAD/4gIcSUNDX1BST0ZJTEUAAQEAAAIMbGNtcwIQAABtbnRyUkdCIFhZWiAH3AABABkAAwApADlhY3NwQVBQTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA9tYAAQAAAADTLWxjbXMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAApkZXNjAAAA/AAAAF5jcHJ0AAABXAAAAAt3dHB0AAABaAAAABRia3B0AAABfAAAABRyWFlaAAABkAAAABRnWFlaAAABpAAAABRiWFlaAAABuAAAABRyVFJDAAABzAAAAEBnVFJDAAABzAAAAEBiVFJDAAABzAAAAEBkZXNjAAAAAAAAAANjMgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0ZXh0AAAAAEZCAABYWVogAAAAAAAA9tYAAQAAAADTLVhZWiAAAAAAAAADFgAAAzMAAAKkWFlaIAAAAAAAAG+iAAA49QAAA5BYWVogAAAAAAAAYpkAALeFAAAY2lhZWiAAAAAAAAAkoAAAD4QAALbPY3VydgAAAAAAAAAaAAAAywHJA2MFkghrC/YQPxVRGzQh8SmQMhg7kkYFUXdd7WtwegWJsZp8rGm/fdPD6TD////bAEMABQMEBAQDBQQEBAUFBQYHDAgHBwcHDwsLCQwRDxISEQ8RERMWHBcTFBoVEREYIRgaHR0fHx8TFyIkIh4kHB4fHv/bAEMBBQUFBwYHDggIDh4UERQeHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHv/AABEIAMgAyAMBIgACEQEDEQH/xAAfAAABBQEBAQEBAQAAAAAAAAAAAQIDBAUGBwgJCgv/xAC1EAACAQMDAgQDBQUEBAAAAX0BAgMABBEFEiExQQYTUWEHInEUMoGRoQgjQrHBFVLR8CQzYnKCCQoWFxgZGiUmJygpKjQ1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4eLj5OXm5+jp6vHy8/T19vf4+fr/xAAfAQADAQEBAQEBAQEBAAAAAAAAAQIDBAUGBwgJCgv/xAC1EQACAQIEBAMEBwUEBAABAncAAQIDEQQFITEGEkFRB2FxEyIygQgUQpGhscEJIzNS8BVictEKFiQ04SXxFxgZGiYnKCkqNTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fr/2gAMAwEAAhEDEQA/AMpEqxGMHpSRqKmUV9IeVcljGamCjHSo4x7VOF9aTKHRqKcyjNKi4Gc1JgY6UgGxKKtRxjrUUSNmrcUdICSJQBg1etwvAqoi81ZTIAxUgidwooh64FMRGfrViNAo7UhnM/Eu51vT/DjX+iyqjROPPGwFthIG4Htg4z7E9MV0mg3R1HS7W9NvJbtNGGaJ1Ksjdxg88HP1rl/i14gg8OeDXup7eWcTzxwhYzjHzBySe3CEfUiu4sp4ry2huowwWeNZV3dQGAIz781nF++1cpr3USgAAYqeJQTTAuDzViIAkGrJLECgDgVYQCoVxxipk4qRgDlsVetxhOAaoJy9X4WbAFDAtQqWxVwRgAAc1DbLnAFW0UDvWbY0NRNoqUwjG49aVAKnRVPJ5qGykRxp04oq0gAFFTcdz5URcdqnjXNORM1NHGK9K5zpCxLiptvFAAAp6ipGNXnjFTxR7uaSKPLDpVyIKDzSbGJFEBziplHGAKcpBHSnxgE8UgGopJ6Vct4Se1EKDPNXIygAwBSYIb5W3k1S1XUtO0mze91K7htLdODJK2B9Pc+wq5qd3BZWFxe3LiOC3iaWRz/CqjJP5Cvkv4g+M9S8X6ubi4dks42P2W2z8sSnv7sR1P8ASsKtVU15mkIObPQ/i58UNN1PT10Tw8YrmJ5Ve4uLiA7fkZWUID15HJI6cDrXf/D/AOKnhvXoILfULuLT9T8sGVZAUhZ++xj274OOvevlU5J6ip7SSSKQPG3zDoa4liJ83MdDpRasfc5O4h1YMpGQQeCKkjevFPgL46+1R/8ACOancBXBH2QSHk5HKqe4yM46jPp09ohIY5r0Kc1UjdHJOLg7MuxOV61Op8wjBqBUyoIxipo2Crx1piJUAD+lX7ZlyBWdAu5+TWnaoopMEXrcfMSatpzyeKghI249KfbypKGKHIVyh+o4P61nItFlADzU8ajFQJxViMkjis2hol49KKM4opWGfMIUgcUoYg04ZpCo716BgOBPrUsTZOKijx0qSNDu4oHctIQO1OVjnmmohxzS7PQUguWY2q3CKpQD2q6hx1osBYQ4pytg5zUQPGacvty3alYLnnPxw1xLvRJPCunXO68lkja72nCRRDna7epO35epFeR23heyXBuriadu+zCL+vNbY+0S3U/2gnz/ADWadm6mQk7iffOf0qwvlqRgEnua8KvXc5XsejTpqMTKi0DR1X/jxDe7SsaSXw5pEg4t3hPqkp/rW15ihs7RjPrUqvGzZ2jk9c1ipy7GlkUfCtnJoV3I0WL62lGRE5EUscihvLkjfkblYhsHrjFfQ/hbWLfWdJhvoC3zDbKjJtaOQD5lI7YP9K8X0rSptUvBa6dE807KzLGi5LYGTgd/pXY/DG4uLXWxZSh1EyMrKR1wu5SfpggHuGx2FdeDr2ny9zDEU7xv2PWYH45qXePWqsRx1qbIPavXscFyzbvzkVpwPkDmsiLjpzV2BzipaGmasUhqppesaZP4j1LRob+3fULcRzTW6v8AOisoGSPwH5j1p0LHA714lpvxH8Nab+0FrG7SktYrtU0+51KSYIEkiJ3SkdNjYQHnPyg+1Y1LK1zSF3c+iYz71ZQ4HWs+znint45oJUlidQyOjBlYHuCOCKtqw+p9KloaJ8nGaKSMMaKkpHzbs46UgHPNWwqkdDQsAJ7ivQucxCsfoKeilDnmriW429aeLYkcEUrjI4iCOlSrHk5xUkVqwxwKti3+XpSuBXhQYqwqZpUix2qdIz2GaBkO3FPRD6VOsJJ6GrENsSQD0zSEeCfEqXS4fFuptZkARBGvCjA5lIycenbPvmuStdeszPFuPlwTQebGzn5shipHv0yKb4jMs+teMLm4k33BvZVIJwyoGYLkfQD8ql8FRo2h28jqnmKWQHHO0Hj+Zrw6/K3JnpU72SJNS1oR6JcXtioeRZUiUuhAG4Ek4PXpTvD2tC40lrzUjHG0c4iZwMBsjIJqHxpJC2kCNHVpBOuQDnHDUnw+8j7BdJKVDGZcBu/y1mkuQu75jpNE1myTWHa01BrQ2tsbr7VExOCGVVUBeSSzD6V6x4Plt7y302+jTbcvdmKds5DbYH24PoQM/ia8X8R2dvaaRe3UFvEksqRwsyrg7TKjHp7qK7/wNJq8fijQdOkVrbT5EF3buB/rSS0b57EfKB6jJrbC8qmpGda7i0exovPJqdEFCxVOiEDFe0eYCKM1aiTio44yT0qt4o1KPQ/DWoarNNDF9mt3eMyvtVpNp2Ln1LYAHeobsUlc8P8Aj/8AFq8tdQvPB/huUQrF+6v7xT85b+KND/CB0J6nkDFeBxzSZBDEfTiti18O6pqEzXd/KsDzMZHaT5nZick4HTkmtm18I6eoHnXFzKfbCivLqVuZ3Z3wp2VkaHwh+ImseDtftD9tnOkmQJd2xyyGMnlgv95c5GMdMd6+1/Deqafrekwappl1Dd2s4JSWJtytg4OD9RXxNF4W0j+EXQPr5n/1q9Z+DXjG68E26aMbdL/SJbkySHBW4iLYBYEfK4GASCAevOaKdZXtcU6btex9MIBiinxjsexorouYnz6LbjgVILc8DFWUXHWpQnHSu65gkVktjjpxViO3x2qWMEHoasRoSe9K47EKQeg/SpVhI7GrkMbUWuZovMYKMuyjng4YgfyqeYdiukBzkirMUC9StWo4G9KmERA6UcwWKqwqD0qn4h1rQ/Denm/13UoLG3GMGQ5Zj6Ko5Y+wFcj8cPiPH4D0mK3s1jm1u9VjbI/KwoODKw788AdyPQV8lavq2o6vqEt/qV5Pd3MrEvLK5Zj+J/kOKwq4hQ0W5pCk5as6bUPEFrrPibWLqW3S1t9RuWmHJyRnhWPHUHPatnT44dscUCokYXABNebI7A5INa+h6zLYXSFnLRZ5Vuw9q8yab1OyOh6MsYhhUERZyQDT1RJVf92hI6e1VbG7NzFvDuP93A/nVppRHGXZpCB7Ka5+SV9zTmXYnt9Eu9RtLoNFI1qI/ncHKrgg4yeh6Vqap4s0WwuvBlrq9vd/bdFvFkWa3cDMBdywYZHOWHHoD+PE6144uLXTZtH0yGKF5CRPdAfvGXghB6Djnr1rjEvZVdn3ZZvvMRkmtqaknd9CJ2asj74tzHPCk0DpLFINyOjAqw9QRU6RdyK+Ofh18Tta8JRxW9rck2qMSbZuY2GckbTwCecEYOa+uvCmt2XiDS4r20mikDxq58pw64YZBz26EYPIIIPSvWp4iM9Op586Thr0NONccYryr9o/T9QfTNK1RJc6faSOsyE4CSNjbIR34BXPbPvXrgAHf9K+f/2ldTkuvEMejN89tBaAbc8B5ASW+uNo/CliH7jHR+I4O2aMoGQBs/xGp0d5Z0gjkw75xjsB1NcN4Vj1WexcW99FDAH5JBd1OOcDoK6jwxYXFrrIumvJLxDCVJkIHJIxgfga8tR961zvb0NkyWcEvkvdzGUdTu6Gu++D8MF3400+1ukiuYmk8xSTg5UFvoenIr5+v9WljbcqDzvNcOSDjhj09a9G8PXV+lkkun3MlreIN8U8bYaJsfeB9q0Su9SX5H2rE2eaK8Z/Zf8AGuu+I7LW9F8RX51C90udGjuGILPG+4YJHXDLwfQ47UV1p3VzmasyJYzUscZJ6VMsRzzT1TaetddzIdDCSKsxwH+6KbDT7uaW3tXuI0EnlKXZMcuoGSB6H0qWxnD/ABg8SzeFNCl1G1imeSMoH2yAKuchSwzkA8jgEH6gVxvwm+Kmo+Itbg0i80+PzEj/ANHIysMbY5d8AseOnoSeeRil8avEK6lp1v4hsLaW186A2Eglt3jnhyQ+JQRgqcAqQSCN3uK4P4UatqFh4tS50SJ3lJHmKbdZI/LL5bIxhcjAB/hJzkCuCpWanozpjC8T7GgjbYu8oWxyVHGfapXCRRtJK6RxoNzO7AKo9ST0FZegeKPD+siUadqVrdPAoa5FvKJVgyM4Z1+Xsec1k/Gizkv/AIb3klvO0IheK4YHIEihgNpHvuBAPcCulz0ujBR1sz5j+MUF/wCLfiZrGqafCy2RlEMMs8y4dY1Cbk9EJBIHv71zCeCdQI+e9sl/4Gx/kK7C41C0tL6CBxHIlwzIkwfcN46qcdDyK0JZ44oJZpGhhhhTfI5XO0fTPWvOlNuW2rO1RSR583gvUV+7e2Tf9tCP5iql14b1q3Qt9l89R18pg/8ALn9K7+z1S1vrVruzmjuoEkEcoaHY8ZPQ4B5FLfS2kcsMLRYmnbbEsTfMx+noPWk5NOzC3U5bw3q0Wn6aEvDNEVbaf3W7B9D6VpXPiCwubKaO3neRwhODER+vap7iCGW78q5QSB0/jAyy/XuPxqG20uwsnSKKNWBYk+b82fT8qxfLfUtXscXa2l7dnMFrPMTySqFs/jWjbeHNYd1EtnNBGT80ki4Cj1Peu/WWKKSOGZ50L/6tSNgbHpTdXZItOuHgiHmiNim9+MgZya25raEWODfw/rMT/wDHlKQDwQAQf1r2r9nh5NG1e0FxpT24nnFvJeWV0H8zf8qpcQbs7dxXDgZU+xNcckkMsW9fKkZABKIZg2xu4PHrWl4f+yPqltDLem1eRwsTS9N3sRkin7RwaYnHmTR9crER1r5z+PirD8RpnlUFTBA2D6bMV7/4EjvX8M2z31wLhmz5cgk35ToPm/iHBIPoR6V43+1TYxw63pF6i4kuLVo2/wBoo/y/+hV3VJ89NNHJTjyzseWQQiK5kAQAk54UAdParOnwhdQU4C78g4HWs3U9VS086YRSO8YA246nGP8AJqXStQkuJ7QyRNayyOCUcdvb1rzrPn+Z23XKVLK0aXUZbc2VpIreaArrnnB5+tdH4PKtLEJEV18vJTseORWVDBdDW5HhmKpDId8hThj6KPx5NXdJSfT9TtgkokiZwhZl+7n1wapNJ2Jfc91/Zq0uC38ReJLuG2ji86OLcwXBOXZh+Heil/Zz1q2bW760MyJLc2wRUJ5aSFyrAe+OfoaK6abfKYz+I1Qh9KXyc9quLH7U4R+1dfMYWMe71G0sLiKC7Yw+a21GfhTx2P8AP0+nNcn4o8VavoOpSfY5LTWrBBFK1vaKZL6KLP7xmA4ZCDwwwemN3Ndf4u8N6f4m0OXTNQtY7hMiSJZHdQsgB2tlCGGM9jXztq0A8D3cHhvxbqMF/pRVmtTpF2Bd2kgO4IXYGRIge3/AsdqyqVGi4RTOW8U3sE32uRLm9yd0jsb07mjdgTAUJIG3PKnGcdyKx/CLNdaoiLaTXcMMbSyxRybMAdWIwxYDqQAfpVvxzp2jJFPeaX4ostUllkEkkEMckrKMAkmeT5mAJOTxk9BXP6SqRGNmQiXorJw6nseO+e9efPR6nXHY+mvhzr91418SWVjc3Fzo8enbpYtKsoVjDANgPNIeSAMAKVBbr9I/2kdQ1RPGXh/Tbe4uksDp9zPcxRuwjlYsFTcOjEEcA5x1rb/Z7uILPw1Z/aYtJ0o3K+WA02bi6ccgKCTlDye7ZzkAYql+0Tq1pPq1jpFowN5Zxu07Mhwm/btGeM8DPHHNdKlandsx5ffsfP2maWurmVGuJYRZXhYlDg5aNQMHtjafzrQ1rTRpnhbVNk886ziJWM8m4jD9qdb266S5VLt/9JmMsh25DYHoPT+tWb2KLVLCRJ7qUwuQrCNscjkcY61y89pXvob20sYHgW1a60rVrZHaJZWhDSIcMuCTx+VTatpM+nrLqT6jPcJBbSp+8HzLvUqMEe5FaFjYQaRaXD2VzMAWV38x+CRkAdOnNQ6vJLf6dcWvnx7JVwSuD0II/UU3O8k09AtZalK2m8nT9KGTuVnDY7KQD+WavRXI/t2Pc2FSORgewbb8v61nTSNHBZxOq/uvkyD1qaGQx6r5ioHK87d2KT+O4l8JR0k3N7DfWwu9s0N5HcK8hyI1G4M35kZqtrGpXlzI0B1Dz4h8u5E2BvX3I+tUNSE1ne3EfmAedhpEQ8YzkA/oaqKx45/WtNBHQ+HdRFpdTvOzYnhMW7OSG7E+tbehLqEHiC01R72Fkgt5ykynbsJhcA/XJAGO9cMrE9/1rf8ADd/IS+muSVuFZEOM7WNTIEfW/wCzT4guLzTr3w7c4f7FBFdRyE5bEjOrKfxQH/gRrjf2tbiKbxdpFg84/wBGshMqNjCO0hIb15Cj8K6H9n5bW58N6umk3MVh4na08hZnTeUQM7I23+IBmGeM188+I9V1BWu7vULie4vTMyySSMdzPk5Jzz69a1c/cSM1H3myHxDf2UWn3ET7Jp7oElR39z6Af0qzo+uWF1aR27BIpQoUxvwucdjXCSSuzl2JLHkknOaZ5mOPbFZ+zT3NFJnq8buQiCeGJenyxlv5kVYhQZ+e9V89vLA/rXHeENVadXgn2PLHgqzDqPerra/qEeqQ2DaPbebNIscZDnD7mAGOPesmneyRatY95+GWpx2Ov+GIYbeOKO1JjXjbvZ8rJz7hiee60VzUtxY6wt3Y6ZdOINGc200833XkYn5UOfY8YwB9aKdObithTgpM92EPtTEeFpZIhIvmR/eU8EDrnHp79KuqK8t/aKtZ7bQ9O8RaSZoNasrxI7e5iZtyo33kK5ClT6NxxXc5tK5yqKZ6U+2KFpXDFVGTtUk4+g6182ftH3/g7XYbPxBouqaTeSKWgu40KrMxAIXcMCTI6Z6cAGuy8A/Gixsbe40zx/dJZ3tsCyXY+dLvnogQHBA7ZwOg6VZ8X+Afhh8Q2h1q38RWUD3VwGuLmG7jEkuUO2MBvuEcHGM4BzmonLnVkXFcrPlGS1geweZLqNJYgD5EkYVmHXIbv/P2x0rWIdHDeYC7AhUHJ5HWuk+LPh/RfDPimXS9C1WXUbeJijvswNwA6OCVce44HTrnGH4XsBqmrxWJ1DT9O8zP+kX0pjhUgZ+ZsHFcrXQ2TPcfgv4l8MeCtKu9U1iOKPVIw4iikhDzXLYGwRPgiLAJGD971xUfjLxBD4t1mfUlvUuZGt40+XChQoGVGB03bsHH515rovhifzTNOltLbrkqYZAwcg/wt6ZFQ6zNDG9tJZTvHNNhnRHyI1BwMjH3u/0qeZyXKNJJ3LF3qckmqKZIzG1s+UjlG0uMdD6Hp04rajbULyNJGu7W3D9EjgaRwfTJIGa4G7u5UvUlWUSgDjax9a6nw5qM97eBrwlo4kJESD5VGP1P9aTVugJhNe38GVN3aXAB5E0bRN/UVBNq1sSPtMYtyVPIcMp+hFTadBpGsE4lvLoq2Gj8/wAsL/wEDOPxrZt9B0iDBTSrFT6y5kP/AI8apuKCzOMu9WtHKRwLJKUbIKjFTR30wf7XJp12Fb5N2whefciu9hVYRiFoYR6QxAfyFc94vmllubW0jeeaTJk2nJyT8qjn6n8qLx6IdmRSeDbzUbg3Ul7a28bAbQSXIGPwFX7PwBpjAibW33j+7GuP51qaXpFxHbQR3JjW4ZM4fLZI96qanrl9osr2z6bb/aNu6PcWKSqOu0g9fatHdLREKze4q/DvS/4dck/79r/jU1j4Djs7+C+sdXjlmt5VkEcse0Pg5wSpJGenSsSP4h3RPOkWP4O9bWleIp9bu7TTo9Li+1XGWCxuQETruYn25/KpvLZorQ6u18Zt4AW4li8oXMkMv2OSaMuVdguQArDOMYBJGN2cdq8/SxGv5uL2+2tNK08rIu5ndiST6DkmtDxpp15Be2yz4mtvO2h8Z2EDO3npkiq+hxkzgz7NjOcLGu3gdj/9aoTUVYdru5PB4Q0LA3T3cp7/ADqP5CpR4Q8Ojqlz/wB/v/rVrPb28hhZGZXB5MeFI9vp7VOluj3KiXc6qOgPBPqR3+lJ1WnYagrGOnhLQ7dvPt5723cDqJQR+RFWrHTYRdW032ppJYZQ8RKqMMDwfrV+8sxPbPCkkkCvxlcZH0z0qhp6G0eJEQukTAAswyQD3qHVZSgjtPCHhW3W2vNP0+8kjt4c3MpuGyzSye47BVHJ/vGis7xvqV3pOh6zfWwaKK61O1wBxuh2cj25UUVe6TsLbQ918AeKrPxfpMmpWMUkcSzGMBxyRwQ34jn6Y9a+evjn48udYu7iGw1KWxa1L2d9psoyJNkh2yLkdwR6Ec15hpuq+I9LtSdM1a+tIpG3MIJ2X5vXAPtWXql/qWp6hJd6pdPdXExzJNI+5nPTJPrWsqvMrGPs+XU9Zt/Evg3xP4CGi6vepo9zbTPPOVtY1lvCwAULKFOME7iMDKrtFeV+IrSHRW2WGuQX8ckhJ+zhwuVHDEMBnqccdPrWc6yqwxwD0FQSO8hdpiZXbqzPk/manmuNKxFPM1xgu7FlG1eeAM5wPQcngcc1PZkIyoCzOTjYg5/M1VIw2NpBHU4zWjBNBLDslOGHAbA4HU80mUa8kmrzyR6XKo08RrxG7mPccdc9CcH6GoPENjPp9y1uykTbOR5gJxjsR1qrcX8zR+R9qa4jbBwx3c/U1GLh5GLzzSSEnku28n69zSVrAZ7rNASjqVY+vpW9oOoNpxEjSPvBztC5BOe/r9B+dY001ygIlDBZGB+ZQN2OhxWvoFpb3E0VzfECEZyu4gkD3+vb61T2EdNozTXepPfNaxxRyL8q7QCPY+59a6IusMLTztbW0K/edsnFZelzW8tzK1oirbKcRkfxe9VviC5/4RlQDjM3I/KsopylqW9Eb4LSxRzwXcM0Eg3I8a8MKoaJEkvi7UriUbhbQxsvt8p/+v8AnVDwJIR4Vj3E4FxJjJ6Dir+iMV17WzlQGgiHzNj+E9K0hFKqTJvkOO8WapeTakAZnV5PnLA8qOyr6VsardS6j8PLPULhi91ZXQj8xjlm7cn8vyrmPFRxqcZ9YhXY/D6ys9b8JS6XeTukZumZth+YcAg5wa1h1JfQkh8G6ZcqtxJJcqZQHKRsoUZ544qp4bu303UvFWowALNa2brDj+DMqJx9BXZWyLHBGinIVQAfUAVj3uiWVhoXiXU0uH864s2DI5G3JcNgcdcgVz0puTaZpOKSHaTO97pVxZyuzpLEZYtxztcc8ZrL0aTc8Z/6aMPzUVY8IzDybY9cxMMZ9qy9InCXcdvtcu0m8YHAAHOTRNWQ4nWxNgg1qqALse+awo24xmrdhfy3OpLCtnOPLbMkjYCBccEHuT6Dn1rmexqjZI4P1FZMy7ZZB3ya0tQuPstnLceTJKqIWKxjLcDsO9VVga4xcEGLeqsUYcrkA4NJJy2Bu250XxUi+2eBLiUc7tOguBx3SRM/oxorbvdPh1T4XM8Vwpni0u4hlibqcKcEf98g4NFddJOMUmYzabuj5t2SLads4BVDJgsMjn9ay22NK2IxEPQnNaV7FJ5KjyJGLHd8wyCB1x3FZrxurtiMjuR1wDSjsSyGcN0yce1VJFYdHBz71blAKjapBxzzUQVCACMMeKtMQ+1kFuwLsvzcNkZGP60l1FEjiaAlQSCEK8KPfNQmBNu4zIOeRg5FSpBEWG2eRhj95gdvakMWzeGAtvhS4kJG3cCQCO3Bq8gknka4ECxISWKwrjHfAHWodNW2MpIjlYqOC0wX5vwFPv7tBMT5MOUAAjTKjjufr+tF76AVZhC90VndwQcAL90ewrTsXiykG9TFIuT04bnsOlYwuFl+SdMjquOMVftYo03ypFJtI+UB/u+/qabEdFpWsw2Ehhus+WoARYwC31//AF1Z1i5PiDS47S1jeN95kJcfKBngZ7msSwjD5jS1hL7iyswOTn866G3/ALXt0CxX1gnH/PsxoirbDbH6JG+j6F5cum2t/cI8jr5pLImcEcZGeQM5/Cp9Hv5Lq9eKWzgtptoMrxjDSb0Jweegxx7VUuH1d0YyalaHKkHFqw4/OqPhiS5e5nuWmhZwpyjAqTtXaoz+NUotyQm1YxPFgH9oRc5/dCuh+EjH7Tqce5gPs28AH+IZwfrXN+Jn3XcLHGfL7V0vw4s7yzVr5hGi3iiKISHGUJwXGPTnjviqgnewSeh3EDgwJz/CKxPHbsPBt8I5HB+1RBsHqpOcfTOKsx3JVVjHzFflyO5HFUPEBNzp1xp1wwhWaVdzYy0ZTB6d84rmoxakzSbujh9I1m+heGJJhsGVxtHQjFdFpUgW9YZ6rXJ2en3h1WSzhjM0luxLsgJAUHlvpyK1tLkvxdu5WOTYShAcLz7Vc4uQlKx20MgIzWvpEoCSZ9RXIwXd4BxZof8At4Wrcd7q6xMLaxgDtjBkuVwPwFYulItTR20cwYdaqaoSt1wxAIB61y+kL4vmvBGVtJvMOFBlVQD9a1tZGu2vkG50h3fbtYwzI4JH0NZyoyRaqJnp/gaytL7wqPPjLOGljYhiMj0/I0VS+DGpfadPvLG8hlsJI5fNQzLuVwQARlckHI7iiotVWw7we55hc+DrKS4XGrzLbrnb5gLvz/tKOB1/Oorv4f2sVpJcWGsSXGGGYYYw0ij1Ckhmx3AGcVVj8V6cOLqC68zuHwBn86jl1qwuGZ7eQpk52OePr6CvY5aXQ4LzOM1a2S0umi+0ea2MndGyHnvz14wfxqgwUr8+T6c1va7DeXl20gilu3YcSAMxVR0H0qjFoeqzDKWT8njcQv8AM1zyjroWmZEijHytn2xTVVgeDivQ/B/wl8U+Jrsw25sLRFQyNJcXA4XpkKuSa7q3/Z11dYkWfxpotvdSuUijNpKysw7b+OfoPX0osyjwtZpYnUuhI5OegYUy6nMxBMYAz/D6V9FwfszatNA7al4x0zdGQm20tHfI57swA6c8d663wr8CfA2j3EiX1rLrV1HF5ga+ZlQD+8I1KqR+dCQz5R0bQNZ1qby9L0y7ujnkpGSqD1Zuij3JFe8fCf4PxGx+164LbUZ1Q5tCziKLkdZF7gE+nXv1r0XTZdDvY4PD2lxTW8qyhLeOBvJt5cdCVPQ5rqE8P35lW91nUSI1BDxW2URQOoOPb2/GtORLcm/Y5lPhh4CtrqFLzRri3jnhUieC+kwoJPOH5Ht1rmvHHwS1nTg174WvIdesGBZI1cLcKoGcbTgSH/d5PpXsviDQEOmRXGkMZGEQbHnvv6fKyE5yD3Xv9a1/Bt1d/ZTaXMsVxLEiiQ5wWPGDz7E9evY1nKCauik2fD1xd28bvHLNGjISrqzYKkdQQeQR6VS8M3NtCly9xJFF5u3Z5hAyAuMjPbivqP8AaF+CNj49sp/EPhVbaPxPDnzcvs+3BeCkmeBIMcPgZ6Nngj418R6VqWi6zNpur2FzY3tvgSQzptZe447j0I4Paim+V3QS1RpzwxLJFqlzEXtAxRGXay7+vzDrjg/lWhdavpsl9Y2ti7NYeSdiSgb4fnJ2nHGeOx6YPtXLvqd5PaNazy+bFwVDdVOeoP4n86haCRZFZ49ivHvX0I6Z/MVV3e4dLHVm8txfjYwwZBxzxyPerfjRo21G/Awkg+ZWA53bRiuFj+WVCOzA/rW745+bxPdNnhhGf/HBQtE2T1L/AMPsxeK7uB33k208ZJ/iwP8A61RRTwx6jdAMgUvkY6cgVX8AOV8URjP3opF/NaxmH7sjAyDik9h9TqLfWLb7R5RDKQcZK8ZrbjvIVTcSDjkgda86TO4das207LIu6RtueeTWbgikz13w1d2y65bmKYSQlvlcjbkEHkjtWrr99bGRWiuEIDYO1+9eNXd4/nxvb3Ei7UAO1iOeaW7uLliczyk/7xrGVDm6miqWPoH4a41C8vIEuQpWJX5Of4sf1orwnwzq+sWGqxvpuqXdpNJ+73xSkEg9qKylh5J7lKqux6/c/DvSZ4Dte6jOcHftbHtjFZN78KLKRmax1OSGTGVR4tw/HmvSIxIJwuR5QX5GAP6io5PODbVO4gYAyCwJ/HFYKvPuN04nkFz4D8W6c2+xljuEX+K3uDGT+BIrNuh4n01P9MttSjfu0kIkXH1IINe8bpjtzgnuShPI65FPLv5uHJEe3jbw35VpHFPqhOkuh4BpnizVbCfz7WeKKcAglY9hx3HykcVst491+f7OUvRG0e3a0bOjAjHOcnn+derahp2mXn7u7061nJOQZLZWI+vr+dZk3gTwxcoXbRo42ycmEtFj3xmtFikT7JnGP8SNVlhcJaxwOzo3mW93IpBUHPByDnPOfwqK08dXIla6u7G8uHBYsVuwoYEkkAAcfhXQz/C7QpD/AKLPqMGR/wA9lcfXBFU5vhYETEOt3QU/37dTj8iK0WJXcXs32G6f8QtCt7qK+j8JXyyRbWA+1mQbweuC30x6Y712Fl8bdPhilguYNfCuS8RCRkoSDlSQwBHpkVwx+GOpQqfK1y2IPJ3wEf1qpffDzxMkZ8m6sLjb/CrMpb8xR9Yv1HyW6HfWnx98N2c9uzw640USMksLIu1ieQVG75Tnn+VcxrPx8vh43ttR0hL6HTomzIAUV7gEYO9cEZ68ZweDwRXnmpfDrxm0m4aRvGc/LOh/rUCfDzxkp3HQ5sn0kQ/+zVqqse5HK+x9E6D+0lpMQjF5p2oCXy9ssqWseZW4ySA/fArl/if48+GvxF0q2tdUW8tLuz3CzvItPAkjB/5ZsAcMnTjjnkYryy28C+NI33DRjk8HdMnH61o2vgXxczsbnS4WUMWC+enU1k5ruaJeRj6lpPgG3WMWOvXl1yDIJLN0JGccZ4HfqayrqDSFSSa1N7Pbw/IPN2gbSeOhz15rotQ+G3i242sbGIqEC4S4QZOSeR+PWtvw58MtYhs7i11LyIre4RRIudzDDBuMcA5HWqVaKV7k8jfQ5ey8H3eoQRz2mjXbxyAFGVSAR7E1q3Hw9127c3N1YzM+AC0k6g4A4716/oum/wBnabbWKxsY4F2qQB656A+9aIgJ52SnPI+XgfhWLxMuhSpLqeLaf8M9ctbpLq2WOCZc7S1wp7fiKfH8Htak5N3ZpuOeZx1/KvawoZDiUK2OcrjmpFhjK5K7hj1FT9ZmV7JHiY+C2ss2P7T05cespP8ASrifA/VTj/icWAHtvOP0r2LYjICF5+vFPEQZAFc7ug45o+sTF7NHka/AnVNoLeIrAjuVherv/Cj3YL5viNSWH8FrwPzavVolZek7t25GKtqSy/JI27HHcZ+lHt59w9mjyiw+CFvaXcV0/iO4PlMG+W0XqO33qK9FvbfX3DfZNdghf0ayVhn86KftJP7Qci7GcJAiDy1XpyVG0/8A6/akWZm2hFbIHQkAj8DRRXEajmd4ot4kCknGR3Hv602IhG2SNG+B83zH8OmaKKBErShnGNnpwTwPWlDM25gXznb1JAoopMaEXzWk+c8Dov8AkZpQxbcFR0KnGWGM+1FFNDI13uWTrxkncCBSGV1Kq5ycdwCKKKEwYr/PnEeBjuKdGwYLlAc9x2ooqgAyffAI6c8+nejcAwTaDkZFFFAEigKpXGR3I9KcMHccbsc8jkj1oopgSZQHcpPA/umpmwyFy2Ox+brRRSAQH7pGOen/AOqpgny7XK+oyoBoop3AUxRMFZdpwccLwPfinRxqVV0fjqQGoooAc0e0/e6Dg4pyoSgIK5HqTiiiqQh6FwvALewPSiiimB//2Q==";
    public String image;

    public PostAdapter(Context context) {
        this.context = context;
        this.pointList = new ArrayList<>();
    }

    public void updatePoint(List<Point> newPoints) {
        pointList.clear();
        pointList.addAll(newPoints);
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public PointViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.point_list_item, viewGroup, false);


        return new PointViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull PointViewHolder pointViewHolder, int position) {

        final Point point = pointList.get(position);
        pointViewHolder.postTitle.setText(point.getName());
        pointViewHolder.ratio.setText(point.getRating());
        // modificare afisare imagine
        image = point.getImage();

        byte[] decodeString = Base64.decode(image, Base64.DEFAULT);
        Bitmap decoded = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);

        pointViewHolder.postImage.setImageBitmap(decoded);



        pointViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked="+point.getName(), Toast.LENGTH_SHORT).show();
                 Intent pointsdetailsItent = new Intent(context, PointActivityDetails.class);
                  pointsdetailsItent.putExtra("POINT_ID",point.getId());


                 context.startActivity(pointsdetailsItent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return pointList.size();
    }

    public class PointViewHolder extends RecyclerView.ViewHolder {

        public TextView postTitle, ratio;
        public ImageView postImage;

        public PointViewHolder(@NonNull View itemView) {
            super(itemView);
            postImage = (ImageView) itemView.findViewById(R.id.ImageView);
            ratio = (TextView) itemView.findViewById(R.id.TextViewRatio);
            postTitle = (TextView) itemView.findViewById(R.id.TextViewTitle);

        }
    }


}
