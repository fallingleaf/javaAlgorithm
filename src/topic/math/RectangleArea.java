package math;


// https://leetcode.com/problems/rectangle-area/
// Give 2 rectangle, calculate cover area
// Solution: check if 2 rectangle overlap
// if overlap: left = max(left1, left2), right = min(right1, right2)
// bottom = max(bottom1, bottom2), top = min(top1, top2)
// Calculate total area minus overlap area
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(C<E||G<A )
            return (G-E)*(H-F) + (C-A)*(D-B);

        if(D<F || H<B)
            return (G-E)*(H-F) + (C-A)*(D-B);

        int right = Math.min(C,G);
        int left = Math.max(A,E);
        int top = Math.min(H,D);
        int bottom = Math.max(F,B);

        return (G-E)*(H-F) + (C-A)*(D-B) - (right-left)*(top-bottom);
    }
}
